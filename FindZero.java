package learning;

import java.util.Arrays;
import java.util.Random;

public class FindZero {
	int array[];
	int size;
	public FindZero(int n){
		size = n;
	}
	public static void main(String[] args) {
		FindZero instance = new FindZero(10);
		instance.init(instance);
		instance.removeZero(instance);
		
	}
	public void init(FindZero instance){
		Random random = new Random(48);
		array = new int[instance.size];
		for(int i = 0; i< instance.size;i++){
			array[i]= random.nextInt(instance.size);
		}
		for (int i = 0;i<instance.size/3;i++){
			int pos = random.nextInt(instance.size);
			array[pos] = 0;
		}
		System.out.println(Arrays.toString(instance.array));
	}
	public void removeZero(FindZero instance){
		int count = 0;
		for( int i = 0; i<instance.size; i++){
			if( instance.array[i] == 0 ){
				count ++;
			}else{
				instance.array[i-count] = instance.array[i];				
			}			
		}
		for ( int i = instance.size;i>instance.size-count;i--){
			instance.array[i-1]=0;
		}
		System.out.println(Arrays.toString(instance.array));
	}
}
