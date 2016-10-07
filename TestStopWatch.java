import edu.princeton.cs.algs4.Stopwatch;

public class TestStopWatch {

	public static void main(String[] args) throws InterruptedException {
		Stopwatch stopWatch = new Stopwatch();
		Thread.sleep(1200);
		double time = stopWatch.elapsedTime();
		System.out.println("elapsedTime: " + time);
		

	}

}
