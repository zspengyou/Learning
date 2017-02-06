package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndArray {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		Function<Integer> f = new SubFunction();
		Integer result = reduce(list, f,0);
		System.out.println(result);
		
	}

	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		@SuppressWarnings("unchecked")
		E[] snapshot = (E[]) list.toArray();
		E result = initVal;
		for(E e: snapshot)
			result = f.apply(result, e);
		return result;

	}

}

interface Function<T> {
	T apply(T arg1, T arg2);
}
class SubFunction implements Function<Integer>{
	public Integer apply(Integer arg1, Integer arg2){
		return arg1 + arg2;
	}
}