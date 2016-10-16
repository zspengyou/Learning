package StackAndQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Subset {
	public static void main(String[] args) {
		int k = Integer.valueOf(args[0]);
		String[] array = new String[k];
		for (int i = 0; i < k; i++) {
			array[i] = StdIn.readString();
		}
		StdRandom.shuffle(array);
		while (!StdIn.isEmpty()) {
			int random = StdRandom.uniform(k);
			array[random] = StdIn.readString();
		}
		for (String string : array)
			StdOut.println(string);
	}
}
