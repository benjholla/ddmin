package ddmin;

import java.util.LinkedList;
import java.util.List;

/**
 * An example uses of the ddmin algorithm
 * 
 * @author Ben Holland
 */
public class Test {

	private static TestHarness<Integer> harness = new TestHarness<Integer>(){
		@Override
		public boolean run(List<Integer> input) {
			if (input.contains(1) && input.contains(3)){
				return false; // fail if the input contains 1 and 3
			}
			return true;
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
