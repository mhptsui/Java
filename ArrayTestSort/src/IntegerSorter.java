import java.util.Comparator;


public class IntegerSorter implements Comparator<Integer> {
	public int compare(Integer integer1, Integer integer2) {
		Integer absoluteInteger1 = (integer1 >= 0)? integer1 : -integer1;
		Integer absoluteInteger2 = (integer2 >= 0)? integer2 : -integer2;
		return (absoluteInteger1 == absoluteInteger2)? 
				integer1.compareTo(integer2) : 
				absoluteInteger1.compareTo(absoluteInteger2);
	}
}
