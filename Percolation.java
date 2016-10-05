
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	int size;
	boolean[] sites;
	WeightedQuickUnionUF unionFind;
	int top;
	int bottom;

	/**
	 * @param n
	 */
	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		size = n;
		sites = new boolean[n * n];
		unionFind = new WeightedQuickUnionUF(n * n + 2);
		top = n * n;// TODO
		bottom = n * n + 1;//TODO
		//		for (int i=0; i< n; i++){
		//			unionFind.union(i, top);
		//			unionFind.union(n * (n-1) + i, bottom);
		//		}
		//		System.out.println("union find count should equal to : " + (n * (n-2)+ 2));//TODO
		//		System.out.println("union find count equal to : " + unionFind.count());		
	}

	/**
	 * open site (row i, column j) if it is not open already
	 * 
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		int id = xyToId(i, j);
		sites[id] = true;
		
		int above = id - size;
		if (above < 0) {
			unionFind.union(id, top);
		} else if (sites[above]) {
			unionFind.union(id, above);
		}
		
		int below = id + size;
		if (below >= size * size) {
//			unionFind.union(id, bottom);
		} else if (sites[below]) {
			unionFind.union(id, below);
		}
		
		int left = id - 1;
		if (left >= 0 && id % size != 0 && sites[left])
			unionFind.union(id, left);

		int right = id + 1;
		if (right < size * size && right % size != 0 && sites[right])
			unionFind.union(id, right);
	}

	/**
	 * is site (row i, column j) open?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isOpen(int i, int j) {
		int id = xyToId(i, j);
		return sites[id];
	}

	/**
	 * is site (row i, column j) full?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isFull(int i, int j) {
		int id = xyToId(i, j);
		return unionFind.connected(id, top);
	}

	/**
	 * does the system percolate?
	 * 
	 * @return
	 */
	public boolean percolates() {
		return unionFind.connected(top, bottom);
	}

	private int xyToId(int x, int y) {
		if (x <= 0 || x > size)
			throw new IndexOutOfBoundsException();
		if (y <= 0 || y > size)
			throw new IndexOutOfBoundsException();
		return (x - 1) * size + y - 1;
	}

	public static void main(String[] args) {
		int size = 9;
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
		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				int id = xyToId(i, j);
				if (sites[id]) {
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
