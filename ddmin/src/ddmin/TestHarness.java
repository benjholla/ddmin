package ddmin;

import java.util.List;

/**
 * An interface to implement a test harness for evaluating input sets
 * for passing or failing/error conditions.
 * 
 * @author Ben Holland
 */
public interface TestHarness<E> {

	/**
	 * Returns true if the test passes and false if the test fails
	 * @param <E>
	 * @param complement
	 * @return
	 */
	public boolean run(List<E> input);

}
