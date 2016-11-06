package priorityQueue;
import java.util.ArrayList;

import edu.princeton.cs.algs4.In;

public class Board {
    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
//	private Board pre;
	private Integer manhattan;
//	private Direction from;
	private enum Direction{
		UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
		int x;
		int y;
		Direction(int x, int y){
			this.x = x;
			this.y = y;
		}
		int getX(){
			return x;			
		}
		int getY(){
			return y;
		}
	}
    private final int n;
    private final int[][] tiles;
    public Board(int[][] blocks) {
    	n = blocks.length;
    	tiles = new int [n][n];
    	for(int i = 0; i< n; i++){
    		for(int j = 0; j< n; j++){
    			tiles[i][j] = blocks[i][j];
    		}
    	}
//    	pre = null;
    }
//    public Board(int[][] blocks, Board pre) {
//    	this(blocks);
//    	this.pre = pre;
//    }
//    public Board(int[][] blocks, Direction from) {
//    	this(blocks);
//    	this.from = from;
//    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of blocks out of place
    public int hamming() {
    	int hamming = 0;
    	for(int i=0; i<n; i++){
    		for(int j= 0; j< n; j++){
    			if(tiles[i][j] != i*n+j+1)
    				hamming ++;
    		}
    	}
    	hamming --;
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
    	if(manhattan == null){
        	manhattan = 0;
        	for(int i=0; i<n; i++){
        		for(int j= 0; j< n; j++){
        			int actual = tiles[i][j] -1;
        			if(actual == -1) continue;    			
        			int row = actual/n;
        			int col = actual%n;
        			manhattan += Math.abs(i-row);
        			manhattan += Math.abs(j-col);
        		}
        	}
    	}
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
    	int hamming = hamming();    	
        return hamming == 0;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
    	int [][] tilesTwin ;
    	if(tiles[0][0] != 0 && tiles[0][1] !=0){
    		tilesTwin = moveOneStep(0,0,Direction.RIGHT);
    	}else{
    	    if(tiles[0][0] == 0){
    	        tilesTwin = moveOneStep(0,1,Direction.DOWN);    
    	    }else{
    	        tilesTwin = moveOneStep(0,0,Direction.DOWN);   
    	    }    		
    	}    	
    	Board twinBorad = new Board(tilesTwin);
    	return twinBorad;
    }

    // does this board equal y?
    public boolean equals(Object y) {
    	if(y == this) return true;
    	if(y == null) return false;
    	if(y.getClass() != this.getClass()) return false;
    	Board board = (Board)y;    	
        return this.toString().equals(board.toString());
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
    	ArrayList<Board> list = new ArrayList<Board>();
    	int[] result = new int[2];
    	getZeroPos(result);
    	int row = result[0];
    	int col = result[1];
    	int [][] neighbor;
    	for(Direction direction : Direction.values()){
    		neighbor = moveOneStep(row,col,direction);
    		if(neighbor == null) continue;
    		Board board = new Board(neighbor);
    		list.add(board);	
    	}
        return list;
    }
    

    // string representation of this board (in the output format specified
    // below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // unit tests (not graded)
    public static void main(String[] args) {
    	In in = new In("./src/8puzzle/puzzle3x3-00.txt");
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        System.out.println(initial);
        System.out.println("hamming: " + initial.hamming());
        System.out.println("manhattan: " + initial.manhattan());
        System.out.println("twin: " + initial.twin());
        for(Board board : initial.neighbors()){
        	System.out.println("neighbor: " + board);        	
        }
    }
    private int[][] moveOneStep(int x, int y,Direction direction){
    	int row = x + direction.getX();
    	int col = y + direction.getY();
    	if(row < 0 || row >= n || col <0 || col >= n)
    		return null;
    	int [][] tilesTwin = new int[n][n];
    	for(int i = 0; i< n; i++){
    		for(int j = 0; j< n; j++){
    			tilesTwin[i][j] = tiles[i][j];
    		}
    	}

    	int tmp = tilesTwin[x][y];
    	tilesTwin[x][y] = tilesTwin[row][col];
    	tilesTwin[row][col] = tmp;
    	return tilesTwin;
    }
    private void getZeroPos(int[] result){
    	for(int i = 0; i< n; i++){
    		for(int j = 0; j< n; j++){
    			if(tiles[i][j] == 0){
    				result[0] = i;
    				result[1] = j;
    			}    				    			
    		}
    	}
    }
    

}
