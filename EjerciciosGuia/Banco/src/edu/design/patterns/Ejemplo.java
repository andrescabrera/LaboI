package edu.design.patterns;

public class Ejemplo {

	public static void main(String[] args) {
		int[] nums = { 1, 5, 9, 2, 6, 4 };
		printArray(nums);
		IntegerSorter sorter = new IntegerSorter();
		nums = sorter.Sort(nums);
		System.out.println("resultado:");
		printArray(nums);
	}

	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
		System.out.print("\n");
	}

}
