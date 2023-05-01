import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private final int n;
    private final int trials;

    private final double[] trialFractions;

    private double trialFractionsSum;

    private Double mean;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("N must be greater than 0.");
        if (trials <= 0) throw new IllegalArgumentException("Trials must be greater than 0.");
        this.trials = trials;
        this.n = n;
        this.trialFractions = new double[trials];
        simulateTrials();
    }

    private void simulateTrials() {
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            double fraction = (double) p.numberOfOpenSites() / (n * n);
            trialFractions[i] = fraction;
            trialFractionsSum += fraction;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean == null ? mean = trialFractionsSum / trials : mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double sum = 0;
        double mean = mean();
        for (double fraction : trialFractions) {
            sum += (fraction - mean) * (fraction - mean);
        }
        return sum / (trials - 1);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((1.96 * stddev()) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((1.96 * stddev()) / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, t);
        System.out.printf("mean                    = %f\n", stats.mean());
        System.out.printf("stddev                  = %f\n", stats.stddev());
        System.out.println("95% confidence interval = ["
                                   + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}
