package edu.design.patterns;

public class IntegerSorter {
	
	public int[] Sort(int[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++)
			{
				int primerNumero = source[i];
				int segundoNumero = source[j]; 
				if (primerNumero > segundoNumero) {
					int temp = source[i];
					source[i] = source[j];
					source[j] = temp;
				}
			}
		}
		return source;
	}
}
