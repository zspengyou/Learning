package utils;

import java.util.Arrays;

public class Extend2DArray {

	public static void main(String[] args) throws InterruptedException {
		String [] array = new String[]{"111"};
		int numRow = array.length;
		int numCol = array[0].length();		
		char[][] grid = new char[numRow][numCol];
		FillGridWithString.stringToChar(grid,array);
		FillGridWithString.printResult(grid);
		char [][] extendedGrid = null;	
		extendedGrid = extendAbove(grid,'0');
		printResult(extendedGrid);
		int sleep = 100;
		for (int i = 0;i<10;i++){
			Thread.sleep(sleep);
			extendedGrid = extendLeft(extendedGrid,'0');
			printResult(extendedGrid);
			Thread.sleep(sleep);
			extendedGrid = extendRight(extendedGrid,'0');
			printResult(extendedGrid);
			Thread.sleep(sleep);
			extendedGrid = extendBottom(extendedGrid,'0');
			printResult(extendedGrid);
			Thread.sleep(sleep);
			extendedGrid = extendAbove(extendedGrid,'0');
			printResult(extendedGrid);
		}

	}
	public static void copyGrid(char[][]grid, char[][]extendedGrid,int rowOffset, int colOffset){
		int numRow = grid.length;
		int numCol = grid[0].length;
		for(int i = 0; i< numRow; i++){
			for(int j=0; j<numCol; j++){
				extendedGrid[i+rowOffset][j+colOffset]= grid[i][j];
			}
		}
	}
	public static char[][] extendRight(char[][] grid, char padding){
		int numRow = grid.length;
		int numCol = grid[0].length;
		char[][] extendedGrid = new char [numRow][numCol+1];
		copyGrid(grid,extendedGrid,0,0);
		for(int i = 0; i<numRow; i++){
			extendedGrid[i][numCol] = padding;
		}			
		return extendedGrid;
	}
	public static char[][] extendBottom(char[][] grid,  char padding){
		int numRow = grid.length;
		int numCol = grid[0].length;
		char[][] extendedGrid = new char [numRow+1][numCol];
		copyGrid(grid,extendedGrid,0,0);
		Arrays.fill(extendedGrid[grid.length], padding);
		return extendedGrid;
	}
	public static char[][] extendAbove(char[][] grid, char padding){
		int numCol = grid.length;
		int numRow = grid[0].length;
		char[][] extendedGrid = new char[numCol+1][numRow];
		copyGrid(grid,extendedGrid,1,0);
		Arrays.fill(extendedGrid[0], padding);
		return extendedGrid;
	}
	public static char[][] extendLeft(char[][]grid, char padding ){
		int numCol = grid.length;
		int numRow = grid[0].length;
		char[][] extendedGrid = new char[numCol][numRow+1];
		copyGrid(grid,extendedGrid,0,1);
		for(int i = 0; i<grid.length;i++){
			extendedGrid[i][0] = padding;
		}
		return extendedGrid;
	}
	public static void printResult(char grid[][]){
		int length = grid.length;
		for (int i = 0; i< length; i++){
			System.out.println(Arrays.toString(grid[i]));
		}
		System.out.println();
	}

}
