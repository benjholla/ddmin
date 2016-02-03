package dd.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dd.DeltaDebug;
import dd.TestHarness;

/**
 * An example use of the ddmin algorithm to minimize failing input of an XML Parser
 * 
 * @author Ben Holland
 */
public class XMLParserExample {

	// note: these paths should be modified for your system
	private static final String XPCMD = "/Users/benjholla/Desktop/xmlproc/xpcmd.py";
	private static final String XML_FILE = "/Users/benjholla/Desktop/xmlproc/demo/urls.xml";
	
	private static TestHarness<Character> harness = new TestHarness<Character>(){
		@Override
		public int run(List<Character> input) {
			int result = PASS;
			File inputFile = null;
			try {
				// write out a temp file of the test input
				inputFile = File.createTempFile("test", ".xml");
				FileWriter writer = new FileWriter(inputFile);
				for(char c : input){
					writer.write(c);
				}
				writer.close();
				
				// run parser over input
				Runtime rt = Runtime.getRuntime();
				String[] commands = {"python", XPCMD, inputFile.getCanonicalPath()};
				Process proc = rt.exec(commands);

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

				StringBuilder output = new StringBuilder();
				String s = null;
				while ((s = stdInput.readLine()) != null) {
					output.append(s);
				}

				while ((s = stdError.readLine()) != null) {
				    output.append(s);
				}
				
				if(output.toString().contains("UnboundLocalError: local variable 'digs' referenced before assignment")){
					result = FAIL;
				}
			} catch (Throwable t){
				result = UNRESOLVED;
			} finally {
				if(inputFile != null){
					inputFile.delete(); // a little cleanup
				}
			}
			return result;
		}
	};
	
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		String content = new Scanner(new File(XML_FILE)).useDelimiter("\\Z").next();
		
		ArrayList<Character> input = new ArrayList<Character>(content.length());
		
		// chunk input by character
		for(int i=0; i<content.length(); i++){
			input.add(content.charAt(i));
		}
		
		// minimize test input
		List<Character> minimizedInput = DeltaDebug.ddmin(input, harness);
		
		// print the minimized test input
		StringBuilder result = new StringBuilder();
		for(Character c : minimizedInput){
			result.append(c);
		}
		System.out.println(result);
	}
	
}
