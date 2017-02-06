package generics;

import java.util.HashSet;

public class GenericTypeSafe {

	public static void main(String[] args) {
		HashSet<String> typeSafeSet = new HashSet<String>();
		HashSet typeUnsafeSet = typeSafeSet;
		typeUnsafeSet.add(1);
		String s = typeSafeSet.iterator().next();
		System.out.println(s);

	}

}
