package quickSort;

public class MergeSort {


	private MergeSort(){}
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){	
		assert isSorted(a,low,mid);
		assert isSorted(a,mid+1,high);
		for(int k = low; k <= high; k++)
			aux[k] = a[k];
		int i = low;
		int j = mid;
		for(int k = low; k <= high; k++){
			if (i > mid) a[k++] = aux[j++];
			else if(j > high) a[k++] = aux[i++];
			else if(less(aux[j],aux[i])) a[k++] = aux[j];
			else a[k++] = a[i];
		}
		assert isSorted(a,low,high);
	}
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(lo >= hi) return;
		int mid = lo + (hi - lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
		assert isSorted(a);		
	}
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;	
	}
	private static boolean isSorted(Comparable[] a){
		return isSorted(a,0,a.length-1);
	}
	private static boolean isSorted(Comparable[]a, int low,int high){		
		for(int i = low+1; i<= high; i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	private static void merge(Comparable[] a, int low, int mid, int high){
		
	}
	public static void indexSort(Comparable[] a){
		
	}
	private static void sort(Comparable[] a, int[] index, int[]aux, int lo, int hi){
		
	}
	private static void show(Comparable[] a){
		
	}
	public static void main(String[] args) {
		System.out.println("hello world" );

	}

}
