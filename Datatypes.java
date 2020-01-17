package klibj;

import java.util.Arrays;
import java.util.stream.Collectors;

//import java.util.Arrays;

public class Datatypes {
	public static int[][] append2d(int[][] a, int[][] b) {
		int[][] result = new int[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
	}
	public static String[][] append2d(String[][] a, String[][] b) {
		String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
	}
	public static String array2dToString(String[][] a) {
		return Arrays
		        .stream(a)
		        .map(Arrays::toString) 
		        .collect(Collectors.joining(System.lineSeparator()));
	}
	

}
