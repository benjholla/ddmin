package dd.examples;

import java.util.LinkedList;
import java.util.List;

import dd.DeltaDebug;
import dd.TestHarness;

/**
 * An example use of the ddmin algorithm
 * 
 * @author Ben Holland
 */
public class SimpleExample {

	private static TestHarness<Integer> harness = new TestHarness<Integer>(){
		@Override
		public int run(List<Integer> input) {
			if (input.contains(1) && input.contains(3)){
				return FAIL; // fail if the input contains 1 and 3
			}
			return PASS;
		}
	};
	
	public static void main(String[] args){
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		System.out.println(DeltaDebug.ddmin(input, harness));
	}
	
}
