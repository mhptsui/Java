import java.util.Arrays;

public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] numbers = { -4, -3, -2, -1, 0, 1, 2, 3, 4 };

		Arrays.sort(numbers, new IntegerSorter());
		for (int i: numbers) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		
		Arrays.sort(numbers);
		for (Integer i: numbers) {
			System.out.printf("%4d", i);
		}
		System.out.println();

	}

}
