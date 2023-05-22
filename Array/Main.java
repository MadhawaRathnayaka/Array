import java.util.Scanner;

public class Main {
	private static Scanner scanner;
	
	private static int [] _array;
	private static int _target;
	private static Tuples tuples;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("Enter the elements of the array, seperated with spaces > ");
		String ar = scanner.nextLine();
		_array = new int [ar.split(" ").length];
		for (int i=0; i<ar.split(" ").length; i++) {
			_array [i] = Integer.parseInt(ar.split(" ") [i]);
		}
		
		tuples = new Tuples(_array.length);
		
		System.out.print("Enter the target integer > ");
		_target = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("\nIndices of the two numbers whose sum equal to target value " + _target + ":");
		boolean found = false;
		for (int i=0; i<_array.length; i++) {
			for (int j=0; j<_array.length; j++) {
				if ((_array[i] + _array[j] == _target) && !tuples.search(i, j)) {
					found = true;
					tuples.add(i, j);
					System.out.println(i + " and " + j + " (" + _array[i] + "+" + _array[j] + "=" + _target + ")");
				}
			}
		}
		if (!found) System.out.println("were not found in the array.");
	}
}

class Tuples {
	private int [][] _a;
	private int _i = 0;

	Tuples() {
		_a = new int [10][2];
	}
	
	Tuples(int size) {
		_a = new int [size][2];
	}
	
	public void add(int a, int b) {
		if (_i==_a.length-1) throw new RuntimeException("too many matches");
		
		_a[_i][0] = a;
		_a[_i][1] = b;
		_i++;
	}
	
	public boolean search(int a, int b) {
		for (int i=0; i<_i; i++) {
			if ((a==_a[i][0] && b==_a[i][1]) || (b==_a[i][0] && a==_a[i][1])) {
				return true;
			}
		}
		return false;
	}
}
