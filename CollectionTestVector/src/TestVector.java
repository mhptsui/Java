import java.util.Vector;


public class TestVector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> sequenceNumber = new Vector<Integer>(4,5);
		for (int i=0; i<20; i++) {
			sequenceNumber.add(i, 19-i);
		}

		System.out.println("Capacity: "+sequenceNumber.capacity());
		System.out.println("Number of elements: "+sequenceNumber.size());
		for (Integer number: sequenceNumber) {
			System.out.println(number);
		}
		System.out.println();
		
		for (int i=0; i<20; i+=2) {
			System.out.println( sequenceNumber.get(i) );
		}
	}
}
