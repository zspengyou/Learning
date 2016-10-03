

public class UnionFindCanonical {
	private int [] id;
	private int [] max;
	private int [] size;
	public static void main(String[] args) {
		UnionFindCanonical unc = new UnionFindCanonical(6);
		System.out.println(unc);
		unc.union(0, 1);
		unc.union(3, 4);
		unc.union(3, 5);
		System.out.println(unc);
		unc.union(0, 2);
		System.out.println(unc);
		unc.union(0, 3);
		System.out.println(unc);
		
	}
	public UnionFindCanonical(int n){
		id = new int[n];
		max = new int [n];
		size = new int [n];
		for (int i = 0;i<n; i++){
			id[i] = i;
			max[i] = i;
			size[i] = 1;
		}
	}
	private int root( int i){
		while (i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	public boolean find (int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}
	public void union (int p, int q){
		int pRoot = root(p);
		int qRoot = root (q);
		int maxRoot = Math.max(max[pRoot], max[qRoot]);
		if(size[pRoot]>=size[qRoot]){// link q to p
			id[qRoot]= pRoot;
			size[pRoot] += size[qRoot];
			max[pRoot] = maxRoot;
		}else{// link p to q
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
			max[qRoot] = maxRoot;
		}
		
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("i -> id -> size -> max  \n");
		int length = id.length;
		for (int i=0;i<length;i++){
			sb.append(i+ " -> "+ id[i] + " -> " + size[i] + " -> "+  max [i] + "\n");		
		}
		return sb.toString();
	}
}
