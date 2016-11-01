import java.util.ArrayList;
import java.util.LinkedList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    // find a solution to the initial board (using the A* algorithm)
	private boolean solvable;
	private int moves;
	private ArrayList<MinPQ<SearchNode>> pq ;
    public Solver(Board initial) {
        if(initial == null)
            throw new NullPointerException("");
    	pq = new ArrayList<MinPQ<SearchNode>>();
    	pq.add(new MinPQ<SearchNode>());
    	pq.add(new MinPQ<SearchNode>());    	
        solvePuzzle(initial);
//        solvePuzzleSimple(initial);
    }
    private void solvePuzzle(Board initial){
    	
    	SearchNode initialNode = new SearchNode(null,initial,0);
    	SearchNode twinInitial = new SearchNode(null,initial.twin(),0);
    	pq.get(0).insert(initialNode);
    	pq.get(1).insert(twinInitial);
    	int move = 0;
    	while(!pq.get(0).min().isGoal() &&!pq.get(1).min().isGoal() ){
    		
    		for(MinPQ<SearchNode> priorityQueue: pq){
        		SearchNode currentNode = priorityQueue.delMin();
        		move = currentNode.getMove() + 1;
        		Board currentBoard = currentNode.getBoard();
//        		System.out.println(currentBoard);
        		Board preBoard = currentNode.getPre()==null? null:currentNode.getPre().getBoard();
//        		System.out.println(preBoard);
        		for(Board neighborBoard: currentBoard.neighbors()){
//        			System.out.println(neighborBoard);
        			if(neighborBoard.equals(preBoard)) continue;
        			SearchNode neighborNode = new SearchNode(currentNode,neighborBoard,move);
        			priorityQueue.insert(neighborNode);
        		}
    		}
    	}
    	SearchNode goalNode = pq.get(0).min();
    	solvable = goalNode.isGoal();
    	if(solvable){
    		moves = goalNode.getMove();        		
    	}else{
    		moves = -1;
    	}
    }
    private void solvePuzzleSimple(Board initial){
    	SearchNode initialNode = new SearchNode(null,initial,0);
    	MinPQ<SearchNode> priorityQueue = new MinPQ<SearchNode>();
    	priorityQueue.insert(initialNode);
    	while(!priorityQueue.min().isGoal()){    		
    		SearchNode currentNode = priorityQueue.delMin();
    		int move = currentNode.getMove() + 1;
    		System.out.println("currentNOde: " + currentNode);
    		Board currentBoard = currentNode.getBoard();
    		
    		Board preBoard = currentNode.getPre()==null? null:currentNode.getPre().getBoard();
//    		System.out.println("preBoard: "+ preBoard);
    		for(Board neighborBoard: currentBoard.neighbors()){
//    			System.out.println("neighbor : " + neighborBoard);
    			if(neighborBoard.equals(preBoard)) continue;
    			SearchNode neighborNode = new SearchNode(currentNode,neighborBoard,move);
    			System.out.println("neighborNode : " + neighborNode);
    			priorityQueue.insert(neighborNode);
    		}
    	}   
    }
    
    // is the initial board solvable?
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
    	SearchNode node = pq.get(0).delMin();
    	LinkedList<Board> list = new LinkedList<Board>();
    	list.add(node.getBoard());
    	while(node.getPre()!= null){
    		node = node.getPre();
    		list.add(node.getBoard());
    	}
        return ()-> list.descendingIterator();
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        In in = new In("./src/8puzzle/puzzle4x4-36.txt");
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        System.out.println(initial);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
    private static class SearchNode implements Comparable<SearchNode>{
    	final Board board;
    	final SearchNode pre;
    	final int priority;
    	final int move;
    	public SearchNode(SearchNode pre,Board board, int move){
    		this.pre = pre;
    		this.board = board;
    		this.move = move;
    		priority = board.manhattan() + move;
    	}
		@Override
		public int compareTo(SearchNode o) {
			if(this.priority < o.priority) return -1;
			if(this.priority > o.priority) return 1;
			return 0;
		}
		public boolean isGoal(){
			return board.isGoal();
		}
		public Board getBoard(){
			return board;
		}
		public SearchNode getPre(){
			return pre;
		}
		public int getMove(){
			return move;
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("priority: " + priority + "\n");
			sb.append(board.toString());
			return sb.toString();
		}
    }
}
