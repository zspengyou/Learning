package generics;

public class GenericGetClass {
	public static void main(String [] args){
		GenericClass<Integer> c = new GenericClass<Integer>(Integer.class);
		System.out.println(c.getMyType());
	}

}
class GenericClass<T> {

    private final Class<T> type;

    public GenericClass(Class<T> type) {
         this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }
}
