
public class EasyMistake {

	public static void main(String[] args) {


	}
	void sqrtRoot(){
		double sqrtRoot = Math.pow(100, 1/2);//0
		double sqrtRootV2 = Math.pow(100, 1.0/2);//0
		System.out.println(sqrtRoot+sqrtRootV2);
	}
	void NotBasedOnPrevious(){
		System.out.println();
	}
	void printExpression(){
		int n = 5;
		System.out.println("union find count should equal to : " + (n * (n-2)+ 2));//17
		System.out.println("union find count should equal to : " + n * (n-2)+ 2);//152
	}
	void gridTopBelowLeftRight(){
		int id = 0;
		int size = 10;
		boolean sites[]  = new boolean[size];
		
		int above = id - size;
		if (above < 0) {
//			unionFind.union(id, top);
		} else if (sites[above]) {
//			unionFind.union(id, above);
		}
		
		int below = id + size;
		if (below >= size * size) {
//			if(unionFind.connected(id, top))
//				isPerculated = true;
		} else if (sites[below]) {
//			unionFind.union(id, below);
		}
		
		int left = id - 1;
		if (left >= 0 && id % size != 0 && sites[left]){
//			unionFind.union(id, left);
		}


		int right = id + 1;
		if (right < size * size && right % size != 0 && sites[right]){
//			unionFind.union(id, right);
		}
	}
	void arrayIndex(){
		int n = 10;
		int [] id = new int [n+1];
		int virtalTop = id[n];// the last one is n, not n+1;
		System.out.println(virtalTop);
	}
}
