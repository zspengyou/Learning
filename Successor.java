package learning;

public class Successor {
	int [] next;
	int [] pre;
	public Successor( int n ){
		next = new int [n+2];
		pre = new int [n+2];
		for( int i=0;i< n+1;i++){
			next[i]= i+1;
		}
		for (int i=1;i<n+2;i++){
			pre[i] = i-1;
		}
	}
	void delete(int i){
		int pos = i+1;
		int preP = pre[pos];
		int nextP = next[pos];
		next[preP] = nextP;
		pre[nextP]= preP;		
	}
	
	int findSuccessor (int i){
		int pos = i+1;
		int nextP = next[pos];
		return nextP-1;
	}
	public static void main(String[] args) {
		Successor successor = new Successor(5);
		successor.delete(0);
		successor.delete(1);
		successor.delete(3);
		int next =0;
		for(int i= 0;i<5;i++){
			next = successor.findSuccessor(i);
			System.out.println("next of" + i+ ": "+ next);
		}

	}

}
