package unionfind;


public abstract class UnionFindA {
	protected int id[];
	public void printResult(){
		int count = 0;
		for(int iid: id){
			System.out.println(count++ + "-> " + iid);
		}
	}
	public abstract boolean find(int p, int q);
	public  abstract void union(int p, int q);
}
