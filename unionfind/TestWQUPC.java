package unionfind;


public class TestWQUPC {
	
	WQUPC unionFind;

	public TestWQUPC(WQUPC unionFind) {
		this.unionFind = unionFind;
	}
	
	public static void  testUnionFind(WQUPC toBeTest){
		TestWQUPC test = new TestWQUPC(toBeTest);
		System.out.println("-------------- New Test ---------------" );
		test.init();
		test.testFind();
		test.printResult();
		test.testUnion();
		test.printResult();
	}
	public static void main(String[] args) {
		System.out.println("test weighted union find with path compression" );
		testUnionFind(new WQUPC(7));

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
	
	
	public void printResult(){
		for (int i = 0;i<unionFind.id.length;i++){
			System.out.println(i + "-> " +unionFind.id[i]);
		}
	}

}
