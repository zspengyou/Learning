package unionfind;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int numCol;
	private boolean[] isOpen;
	private WeightedQuickUnionUF unionFind;
	private int virtualTop;
	private boolean [] bottomConnected;

	/**
	 * @param n
	 */
	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		numCol = n;
		isOpen = new boolean[n * n];
		unionFind = new WeightedQuickUnionUF(n * n + 1);
		virtualTop = n * n;
		bottomConnected = new boolean[n*n+1];
	}

	/**
	 * open site (row i, column j) if it is not open already
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		int id = xyToId(i, j);
		isOpen[id] = true;	
		boolean left = unionNeighbor(id,i,j-1);
		boolean right = unionNeighbor(id,i,j+1);
		boolean above = unionNeighbor(id,i+1,j);
		boolean below = unionNeighbor(id,i-1,j);		
		if(i == numCol || left || right||above || below ){			
			bottomConnected[id] = true;
			int root = unionFind.find(id);
			bottomConnected[root] = true;
		}
	}
	
	private boolean unionNeighbor(int id, int p, int q){	
		boolean neighborBottomConnected = false;
		if(p==0){
			unionFind.union(id,virtualTop);
		}
		if(p > 0 && p <= numCol && q > 0 && q <= numCol){			
			int neighbor = xyToId(p,q);
			int neighborRoot = unionFind.find(neighbor);
			neighborBottomConnected = bottomConnected[neighborRoot];
			if(isOpen[neighbor]){
				unionFind.union(id,neighbor);
			}

		}
		return neighborBottomConnected;
	}

	/**
	 * is site (row i, column j) open? 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isOpen(int i, int j) {
		int id = xyToId(i, j);
		return isOpen[id];
	}

	/**
	 * is site (row i, column j) full?
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isFull(int i, int j) {
		int id = xyToId(i, j);
		return unionFind.connected(id, virtualTop);
	}

	/**
	 * does the system percolate?
	 * @return
	 */
	public boolean percolates() {
		int topRoot = unionFind.find(virtualTop);
		return bottomConnected[topRoot];
	}

	private int xyToId(int x, int y) {
		if (x <= 0 || x > numCol || y <= 0 || y > numCol)
			throw new IndexOutOfBoundsException();
		return (x - 1) * numCol + y - 1;
	}

//	public static void main(String[] args) {
//		int size = 5;
//		Percolation percolation = new Percolation(size);
//		while (!percolation.percolates()) {
//			int i = StdRandom.uniform(1, size + 1);
//			int j = StdRandom.uniform(1, size + 1);
//			System.out.println(i + " " + j);
//			if (!percolation.isOpen(i, j)) {
//				percolation.open(i, j);
//				percolation.printResult();
//			}
//		}
//	}

	private void printResult() {
		System.out.println("-----");
		for (int i = 1; i < numCol + 1; i++) {
			for (int j = 1; j < numCol + 1; j++) {
				int id = xyToId(i, j);
				if (isOpen[id]) {
					System.out.print(".");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("-----");
	}
}
