package unionfind;

import java.util.Arrays;

public class FillGridWithString {

	public static void main(String[] args) {
		String [] array = new String[]{"11110","11010","11000","00000"};
		int numRow = array.length;
		int numColumn = array[0].length();		
		char[][] grid = new char[numRow][numColumn];
		stringToChar(grid,array);
		printResult(grid);
	}
	public static void stringToChar(char grid[][],String[] array){
		int length = array.length;
		for(int i = 0; i < length; i++){
			grid[i] = array[i].toCharArray();
		}
	}
	public static void printResult(char grid[][]){
		int length = grid.length;
		for (int i = 0; i< length; i++){
			System.out.println(Arrays.toString(grid[i]));
		}
	}
}
