package garbageCollection;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ReferenceTest {
	 
    public static final Map<Integer, Reference> map = new HashMap<Integer, Reference>();
    public static final Map<Integer, StrongReference> map2 = new HashMap<Integer, StrongReference>();
 
    public static void main(String[] args) {
    	testStrongReference();
//    	testReference();
    	
    }
    public static void testReference(){
        for (int i = 0; i < 1000; i++) {
            map.put(i, new WeakReference(new ReferenceObject(i)));
        }
 
        int i = 0;
        for (Reference r : map.values()) {
            if (r.get() == null) {
                i++;
            }
        }
        System.out.println("grabage collected number: " + i);
    }
    public static void testStrongReference(){
        for (int i = 0; i < 1024*10; i++) {
            map2.put(i, new StrongReference(i));
        }
 
        int i = 0;
        for (StrongReference r : map2.values()) {
        	System.out.println(r.geti());
            if (r.get() == null) {
                i++;
            }
        }
        System.out.println("grabage collected number: " + i);
    }
 
    static class ReferenceObject {
        private int    i;
 
        private byte[] b;
 
        public ReferenceObject(int i) {
            this.i = i;
            b = new byte[1024 *10];
        }
    }
    static class StrongReference{
        private int    i;
        
        private byte[] b;
 
        public StrongReference(int i) {
            this.i = i;
            b = new byte[1024 *23];
        }
        public byte[] get(){
        	return b;
        }
        public int geti(){
        	return i;
        }
    }
}
