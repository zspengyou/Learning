package unionfind;

import java.util.Arrays;

import utils.FillGridWithString;

public class NumIslands {

	public static void main(String[] args) {
		NumIslands instance = new NumIslands();
		String [] array = new String[]{"1111111","0000001","1111101","1000101","1010101","1011101","1111111"};
		int numRow = array.length;
		int numColumn = array[0].length();		
		char[][] grid = new char[numRow][numColumn];
		FillGridWithString.stringToChar(grid,array);
		FillGridWithString.printResult(grid);
		int num = instance.numIslands(grid);
		System.out.println(num);			
	}
	public int numIslands(char[][] grid) {
		if (grid == null)
			return 0;
		if (grid.length == 0|| grid[0].length == 0)//
			return 0;
		int numRow = grid.length;
		int numCol = grid[0].length;	
		char [][] gridExtend = new char [numRow+1][numCol+1];
		for(int i= 0; i<numRow;i++){
			for( int j= 0; j<numCol; j++){
				gridExtend[i][j] = grid[i][j];
			}
			gridExtend[i][numCol]='0';
		}
		Arrays.fill(gridExtend[numRow], '0');		
		int count = 0;	
		UnionFind unionFind = new UnionFind(gridExtend);
		for (int x = 0; x < numRow; x++) {
			for (int y = 0; y < numCol; y++) {
				if(gridExtend[x][y]=='1'){
					count ++;
					if(gridExtend[x+1][y] =='1'){
						unionFind.union(x,y,x+1,y);
					}
					if(gridExtend[x][y+1]=='1'){
						unionFind.union(x,y,x,y+1);	
					}					
				}
			}
		}
		return count - ((numRow+1) * (numCol+1) -unionFind.count);
	}

	class UnionFind {
		private int id[];
		private int size[];
		private int count;
		private int numRow;
		private int numCol;

		public UnionFind(char[][] grid) {
			numRow = grid.length;
			numCol = grid[0].length;			
			count = numRow*numCol;
			id = new int[numRow*numCol];
			size = new int[numRow*numCol];
			for (int i = 0; i < numRow*numCol; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public int root(int i) {
			while (i != id[i]) {
				id[i] = id[id[i]];
				i = id[i];
			}
			return i;
		}

		public void union(int i, int j) {			
			int rootI = root(i);
			int rootJ = root(j);
			if (rootI == rootJ)
				return;
			if (size[i] >= size[j]) {
				id[rootJ] = rootI;
				size[rootI] += size[rootJ];
			} else {
				id[rootI] = rootJ;
				size[rootJ] += size[rootI];
			}
			count--;
		}
		public void union (int i,int j,int p, int q){
			if(i<0||j<0||p<0||q<0) return;
			if(i>numRow ||j> numCol||p>numRow||q>numCol ) return;
			int pos1 = i*numCol+j; 
			int pos2 = p*numCol+q;
			union(pos1,pos2);
		}
		
	}
}
