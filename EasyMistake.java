import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import unionfind.WeightedQuickUnion;

public class EasyMistake {

	public static void main(String[] args) {

	}

	void sqrtRoot() {
		double sqrtRoot = Math.pow(100, 1 / 2);// 0
		double sqrtRootV2 = Math.pow(100, 1.0 / 2);// 0
		System.out.println(sqrtRoot + sqrtRootV2);
	}

	void printExpression() {
		int n = 5;
		System.out.println("union find count should equal to : " + (n * (n - 2) + 2));// 17
		System.out.println("union find count should equal to : " + n * (n - 2) + 2);// 152
	}

	void gridTopBelowLeftRight() {
		int id = 0;
		int size = 10;
		boolean sites[] = new boolean[size];

		int above = id - size;
		if (above < 0) {
			// unionFind.union(id, top);
		} else if (sites[above]) {
			// unionFind.union(id, above);
		}

		int below = id + size;
		if (below >= size * size) {
			// if(unionFind.connected(id, top))
			// isPerculated = true;
		} else if (sites[below]) {
			// unionFind.union(id, below);
		}

		int left = id - 1;
		if (left >= 0 && id % size != 0 && sites[left]) {
			// unionFind.union(id, left);
		}

		int right = id + 1;
		if (right < size * size && right % size != 0 && sites[right]) {
			// unionFind.union(id, right);
		}
	}

	void arrayIndex() {
		int n = 10;
		int[] id = new int[n + 1];
		int virtalTop = id[n];// the last one is n, not n+1;
		System.out.println(virtalTop);
	}

	/**
	 * after union, the root of neighbor may have changed
	 * 
	 * @param id
	 * @param p
	 * @param q
	 * @return
	 */
	boolean sideEffect(int id, int p, int q) {
		WeightedQuickUnionUF unionFind = new WeightedQuickUnionUF(10);
		int virtualTop = 10;
		int numCol = 10;
		boolean[] bottomConnected = new boolean[10];
		boolean[] isOpen = new boolean[10];

		boolean neighborBottomConnected = false;
		if (p == 0) {
			unionFind.union(id, virtualTop);
		}
		if (p > 0 && p <= numCol && q > 0 && q <= numCol) {
			int neighbor = (p - 1) * numCol + q - 1;
			int neighborRoot = unionFind.find(neighbor);
			neighborBottomConnected = bottomConnected[neighborRoot];
			if (isOpen[neighbor]) {
				unionFind.union(id, neighbor);
			}

		}
		return neighborBottomConnected;

	}
	
	class InstanceVariableInConstructor<Item> {
		
		Item queue[];
		int capacity;
		int size;
		// construct an empty randomized queue
		public InstanceVariableInConstructor() {
			queue = (Item []) new Object[1];
			capacity = 1;//TODO
			size = 0;//TODO
			
		}
		public InstanceVariableInConstructor(int i) {
			queue = (Item []) new Object[1];
			int capacity = 1;//TODO
			int size = 0;//TODO
			
		}
	}
}
