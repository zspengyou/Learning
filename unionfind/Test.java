package unionfind;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;


public class Test {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##0.00");
		double amount = 2342.3;
		System.out.println(df.format(amount));
		
		
		boolean stop = true;
		if (stop)
			return;
		PercolationStats percolationStats = new Test.PercolationStats();
		System.out.printf("%-25s = %f%n","mean",percolationStats.mean());
		System.out.printf("%-25s = %f%n","stddev",percolationStats.stddev());
		System.out.printf("%-25s = %f %f","%95 confidence interval%n",
				percolationStats.confidenceLo(),
				percolationStats.confidenceHi() );

				
	}
	static class PercolationStats {
		double mean(){
			return 10.2342;
		}
		double stddev (){
			return 12.24323;
		}
		double confidenceLo(){
			return 254235.234;
		}
		double confidenceHi(){
			return 252342.2323;
		}
	}
}
