
public class Search {

	public static void main(String[] args) {
		int size = 10000000;
		int[] array = new int [size];
		double[] result = new double [size];
		long start = System.currentTimeMillis();
		for (int i = 0; i< size; i++){
			array[i] = i;
			result[i] = Math.pow(i,1.0/size);
		}
		double end = System.currentTimeMillis();
		System.out.println("time elapsed: " + (end-start));
		for ( int i = 0; i < 10; i++){
			System.out.println(result[size-i-1]);
		}
		
		System.out.print(Math.pow(1.0009, 10000));
	}

}
