package unionfind;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String [] array = new String[]{"11010","10010"};
		int numRow = array.length;
		int numCol = array[0].length();		
		char[][] grid = new char[numRow][numCol];
		FillGridWithString.stringToChar(grid,array);
		FillGridWithString.printResult(grid);
		
		char [][] gridExtend = new char[numRow+1][numCol+1];
		for(int i= 0; i<numRow;i++){
			for( int j= 0; j<numCol; j++){
				gridExtend[i][j] = grid[i][j];
			}
			gridExtend[i][numCol]='0';
		}
		Arrays.fill(gridExtend[numRow], '0');
		FillGridWithString.printResult(gridExtend);
		boolean stop = true;
		if (stop) 	return;


				
	}
}
