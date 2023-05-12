package timecomplexity;

import java.util.Arrays;

public class BitonicArrayChecker {
    public static boolean isBitonic(int[] arr) {
        boolean checkDecreasing = false;
        long prev = Long.MIN_VALUE;

        for (int curr : arr) {
            if (!checkDecreasing) {
                if (prev > curr) {
                    checkDecreasing = true;
                }
                prev = curr;
            } else {
                if (curr > prev) return false;
            }
        }
        return checkDecreasing;
    }


    /**
     * Searches a bitonic array for a specified value.
     *
     * <p>A bitonic array is an array that first increases monotonically and then decreases monotonically.
     * This method first finds the peak of the bitonic array, then performs a binary search on the increasing part,
     * and if the value is not found, performs a binary search on the decreasing part.
     * It returns true if the specified value is found and false otherwise.</p>
     *
     * @param arr The bitonic array to search.
     * @param n   The value to search for.
     * @return True if the array contains the specified value, false otherwise.
     */
    public static boolean search(int[] arr, int n) {
        int peak = findBitonicPeakIndex(arr);
        int ascendingIndex = Arrays.binarySearch(arr, 0, peak, n);
        if (ascendingIndex >= 0) return true;
        int descendingIndex = reverseBinarySearch(arr, peak, arr.length - 1, n);
        return descendingIndex != -1;
    }

    /**
     * Returns in the index of the peak element within a bitonic array using binary search
     *
     * @param arr The bitonic array to search;
     * @return The index of the peak element.
     */
    private static int findBitonicPeakIndex(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    /**
     * Performs binary search on an integer array which is sorted in descending order.
     *
     * @param arr       The array to search.
     * @param fromIndex The starting index
     * @param toIndex   The ending index
     * @param target    The target value to find.
     * @return The index of the target value, if found, else -1 is returned if no value is found.
     */
    private static int reverseBinarySearch(int[] arr, int fromIndex, int toIndex, int target) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int midVal = arr[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                fromIndex = mid + 1;
            } else {
                toIndex = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 1, 2, 3, 4, 3, 2, 1, 0};
        System.out.println(search(arr, 0));
    }
}
