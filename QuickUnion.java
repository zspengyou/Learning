package learning;

public class QuickUnion extends UnionFindA{
	public QuickUnion(int size){
		id = new int [size];
		for(int i = 0;i<size;i++)
			id[i] = i;
	}

	int root (int i){
		while(i!=id[i]) i = id[i];
		return i;
	}
	
	public boolean find(int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}
	public void union( int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		id[qRoot] = pRoot;
	}

}
