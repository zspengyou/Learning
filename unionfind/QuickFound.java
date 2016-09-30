package learning.unionfind;

public class QuickFound extends UnionFindA{
//	int[]id;
	
	public QuickFound(int size){
		id = new int[size];
		for (int i=0; i<size; i++){
			id[i]= i;
		}
	}
	public boolean find (int first, int second){
		return id[first]==id[second];
	}
	public void union (int first, int second){
		int firstId = id[first];
		for(int i=0;i<id.length;i++){
			if(id[i]==firstId)
				id[i]= id[second];
		}
	}
}

