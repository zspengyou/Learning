package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericTest {

	public static void main(String[] args) {
		GenericTest test = new GenericTest();
		test.unsafeAdd();
	}
	public Object[] returnArrayOfObject(){
		String[] s = new String[]{};
		return s;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object> returnListOfObject(){
		List<String> s = new ArrayList<String>();
		return (List) s;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SuperClass<String> getConcreteClass(){
		return (SuperClass) new SubClass();
	}
	
	public void genericAdd(){
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings,new Integer(32));
		String s = strings.get(0);
	}
	String s = "";
	private void unsafeAdd(List list,Object sub){
		list.add(sub);
	}
	private void unsafeAdd(){
		Set<String> o = new HashSet<>();
		if(o instanceof Set){
			Set m = (Set)o;
			m.add("asf");
			System.out.println(m);
		}
	}
	

}
class  SuperClass <T>{
	T name;
	public T getName(){
		return name;
	}
}
class SubClass extends SuperClass<String>{
	@Override
	public String getName(){
		return name;
	}
}