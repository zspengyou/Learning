
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int numCol;
	private boolean[] isOpen;
	private WeightedQuickUnionUF unionFind;
	private int virtualTop;
	private boolean isPerculated;

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
	}

	/**
	 * open site (row i, column j) if it is not open already
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		int id = xyToId(i, j);
		isOpen[id] = true;	
		int left = id - 1;
		if (left >= 0 && id % numCol != 0 && isOpen[left])
			unionFind.union(id, left);

		int right = id + 1;
		if (right < numCol * numCol && right % numCol != 0 && isOpen[right])
			unionFind.union(id, right);
		
		int above = id - numCol;
		if (above < 0) {
			unionFind.union(id, virtualTop);
		} else if (isOpen[above]) {
			unionFind.union(id, above);
		}
		
		int below = id + numCol;
		if (below >= numCol * numCol) {

		} else if (isOpen[below]) {
			unionFind.union(id, below);
		}
		

		if(unionFind.connected(id, virtualTop))
			isPerculated = true;
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
		return isPerculated;
	}

	private int xyToId(int x, int y) {
		if (x <= 0 || x > numCol || y <= 0 || y > numCol)
			throw new IndexOutOfBoundsException();
		return (x - 1) * numCol + y - 1;
	}

	public static void main(String[] args) {
		int size = 5;
		Percolation percolation = new Percolation(size);
		while (!percolation.percolates()) {
			int i = StdRandom.uniform(1, size + 1);
			int j = StdRandom.uniform(1, size + 1);
			System.out.println(i + " " + j);
			if (!percolation.isOpen(i, j)) {
				percolation.open(i, j);
				percolation.printResult();
			}
		}
	}

	void printResult() {
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
		System.out.println();
	}
}
