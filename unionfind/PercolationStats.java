package unionfind;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private double means[];
	private int size;
	private int trials;
	private double mean;
	private double stddev;
	/**
	 * perform trials independent experiments on an n-by-n grid
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) {
		if(n <= 0|| trials <= 0) 
			throw new IllegalArgumentException();
		this.size = n;
		this.trials = trials;
		this.means = new double [trials];
		monteCarloSim();
	}
	private void monteCarloSim(){
		Percolation percolation ;
		for(int i = 0; i < trials; i++){
			percolation = new Percolation(size);
			int count = 0;
			while(!percolation.percolates()){
				int x = StdRandom.uniform(1,size + 1);
				int y = StdRandom.uniform(1,size + 1);				
				if(!percolation.isOpen(x, y)){
					percolation.open(x, y);
					count ++;
				}						
			}
			means[i] = (double)count/size/size;					
		}
	}
	public double mean() {
		return StdStats.mean(means);
	}

	public double stddev() {
		return StdStats.stddev(means);
	}

	public double confidenceLo() {
		double mean = mean();
		double stddev = stddev();
		double confidenceLow = mean - 1.96* stddev/Math.sqrt(trials);
		return confidenceLow;
	}
	/**
	 * high endpoint of 95% confidence interval
	 * @return
	 */
	public double confidenceHi() {
		double mean = mean();
		double stddev = stddev();
		double confidenceLow = mean + 1.96* stddev/Math.sqrt(trials);
		return confidenceLow;
	}
	/**
	 * test client (described below)
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 2;
		int trials = 1000;
		if(args != null && args.length >= 2){
			n = Integer.valueOf(args[0]);
			trials = Integer.valueOf(args[1]);
		}
		PercolationStats percolationStats = new PercolationStats(n,trials);
		System.out.printf("%-25s = %f%n","mean",percolationStats.mean());
		System.out.printf("%-25s = %f%n","stddev",percolationStats.stddev());
		System.out.printf("%-25s = %f %f%n","%95 confidence interval",percolationStats.confidenceLo(),percolationStats.confidenceHi() );
		
	}
}