package learning.unionfind;

import java.util.Arrays;

public class TestTemplate {
	UnionFindA unionFind;

	public TestTemplate(UnionFindA unionFind) {
		this.unionFind = unionFind;
	}
	
	void testUnionFind(UnionFindA toBeTest){
		TestTemplate test = new TestTemplate(toBeTest);
		System.out.println("-------------- New Test ---------------" );
		test.init();
		test.testFind();
		toBeTest.printResult();
		if (toBeTest instanceof WeightedQuickUnion) {
			int [] size = ((WeightedQuickUnion)toBeTest).size;
			System.out.println(Arrays.toString(size));
		}
//		printResult(toBeTest);
		test.testUnion();
		toBeTest.printResult();
		if (toBeTest instanceof WeightedQuickUnion) {
			int [] size = ((WeightedQuickUnion)toBeTest).size;
			System.out.println(Arrays.toString(size));
		}
//		printResult(toBeTest);
	}
	public static void main(String[] args) {
		TestTemplate tt = new TestTemplate(null);
//		tt.testUnionFind(new QuickFound(7));
		tt.testUnionFind(new QuickUnion(7));
		tt.testUnionFind(new WeightedQuickUnion(7));
	}

	void init() {
		unionFind.union(0, 2);
//		unionFind.union(1, 2);
		unionFind.union(3, 5);
		unionFind.union(3, 4);
	}

	void testFind() {
		boolean result = false;
		result = unionFind.find(0, 1);
		System.out.println("find(0,1)");
		parseResult(result);
		result = unionFind.find(0, 4);
		System.out.println("find(0,4)");
		parseResult(result);
	}

	void testUnion() {
		unionFind.union(0, 3);
		testFind();
	}

	void parseResult(boolean result) {
		if (result) {
			System.out.println("in the same group");
		} else {
			System.out.println("not in the same group");
		}
	}
	
	
	public void printResult(UnionFindA unionFind){
		for (int i = 0;i<unionFind.id.length;i++){
			System.out.println(i + "-> " +unionFind.id[i]);
		}
	}

}
