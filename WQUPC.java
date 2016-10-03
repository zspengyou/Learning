

public class WQUPC {
	public int id[];
	public WQUPC( int n ){
		id = new int[n];
		for (int i= 0; i< n; i ++){
			id[i] = i;
		}		
	}
	public static void main(String[] args) {


	}
	private int root (int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	public int find (int i){
		return root(i);
	}
	public boolean find (int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}
	public void union(int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		if(pRoot>= qRoot){
			id[qRoot] = pRoot;
		}else{
			id[pRoot] = qRoot;
		}
	}
}
