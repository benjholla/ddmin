# Java ddmin
A generic Java implementation of Andreas Zeller's delta debugging algorithm from [Simplifying and Isolating Failure-Inducing Input](https://www.st.cs.uni-saarland.de/papers/tse2002/tse2002.pdf) and [Why Programs Fail](http://www.whyprogramsfail.com/).

# Usage
Given an input that causes a failing/error condition, this implementation of a divide and conquer algorithm splits the input data into smaller sets of chunks and checks if the smaller input reproduces the failing/error condition with a smaller input. This ddmin implementation is written generically leaving the choice of both how to "chunk" the input and how evaluate it to the end user.

## Input Evaluation
The `TestHarness` interface contains a method `run`, which should be implemented to return `true` if the test passes and `false` if the test fails (such as an error). The `SimpleExample` class shows an example of a test harness that "fails" for any input that contains an Integer object 1 and 3. 

	public class SimpleExample {
	
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

The result is the minimized set `[1,3]`.

## Chunking
Chunking is how we define each element in the input set we pass to the ddmin algorithm.  For example if we had an input XML file that crashes an XML parser we could chunk the input into a set of elements by considering each character as an element, but we might be able to be a bit more efficient by considering some of the semantics of XML and chunking based on XML structure. This implementation of ddmin uses Java generics so you can define chunking however you want.

The included `XMLParserExample` class shows how this implementation could be adapted to exercise an XML parser that contains a bug when parsing a certain kind of URL.  The *Why Programs Fail* book contains [an exercise](http://www.whyprogramsfail.com/project1.php) to reduce an XML file containing the error to a reduced input containing the error.  The buggy parser and test input can be downloaded [here](https://www.st.cs.uni-saarland.de/whyprogramsfail/code/xmlproc-0.70a.zip).
