package quickSort;

import edu.princeton.cs.algs4.Merge;

public class Test {

    public static void main(String[] args) {
        System.out.println("hello world");
        String [] testString = new String[]{"c","a","b","d"};
        int[] result = Merge.indexSort(testString);
        for(int i: result)
        	System.out.println(i);
    }

}
