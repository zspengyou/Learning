package learning.unionfind;

import java.util.Arrays;

public class WeightedQuickUnion extends QuickUnion{
	int [] size;
	public WeightedQuickUnion (int size){
		super(size);
		this.size = new int [size];
		Arrays.fill(this.size,1);
	}
	
	private void setRoot(int i, int root){
		id[i] = root;
	}
	
	@Override
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		int pWeight = size[p];
		int qWeight = size[q];
		if(pWeight >= qWeight){
			setRoot(qRoot, pRoot);
			size[p]+=size[q];
		}else{
			setRoot(pRoot, qRoot);
			size[q]+=size[p];
		}			
	}

}
