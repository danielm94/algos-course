package union;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final byte[] ROW_OFFSETS = new byte[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static final byte[] COL_OFFSETS = new byte[]{-1, 0, 1, -1, 1, -1, 0, 1};
    private final WeightedQuickUnionUF union;
    private final int n;
    private final boolean[][] openSquares;

    private int openSites = 0;

    // creates n-by-n openSquares, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("N must be greater than 0.");
        this.n = n;
        this.openSquares = new boolean[n][n];
        this.union = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 0; i < n; i++) {
            int topSquareId = getSquareId(0, i);
            int bottomSquareId = getSquareId(n - 1, i);
            union.union(topSquareId, n * n);
            union.union(bottomSquareId, n * n + 1);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateIndices(row, col);
        openSites++;
        openSquares[--row][--col] = true;
        unionNeighboringOpenSquares(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return openSquares[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateIndices(row, col);
        if (!isOpen(row, col)) return false;
        int targetSquareId = getSquareId(row - 1, col - 1);
        int targetParent = union.find(targetSquareId);
        int virtualTopParent = union.find(n * n);
        return targetParent == virtualTopParent;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        int virtualTopParent = union.find(n * n);
        int virtualBottomParent = union.find(n * n + 1);
        return virtualTopParent == virtualBottomParent;
    }

    // Helper method to convert 2D coordinates to 1D index
    private int getSquareId(int row, int col) {
        return row * n + col;
    }

    private void validateIndices(int row, int col) {
        if (row <= 0 || row > n) {
            throw new IllegalArgumentException("Invalid row index: " + row);
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException("Invalid col index: " + col);
        }
    }

    private void unionNeighboringOpenSquares(int row, int col) {
        for (int i = 0; i < ROW_OFFSETS.length; i++) {
            int neighborRow = row + ROW_OFFSETS[i];
            int neighborCol = col + COL_OFFSETS[i];
            if (neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < n) {
                if (openSquares[neighborRow][neighborCol]) {
                    int squareId = getSquareId(row, col);
                    int neighborSquareId = getSquareId(neighborRow, neighborCol);
                    union.union(squareId, neighborSquareId);
                }
            }
        }
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(2, 2);
        p.open(2, 1);
        p.open(1, 2);
        System.out.printf("Percolates?:%s\n", p.percolates());
        p.open(3, 2);
        System.out.printf("Percolates?:%s\n", p.percolates());
    }

}
