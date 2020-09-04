package leetcode;

import java.util.Arrays;

public class TheKStrongestValuesInAnArray {
    public static void main(final String[] args) throws java.lang.Exception {
        int res[] = getStrongest(new int[] { 6, 7, 11, 7, 6, 8 }, 5);
        System.out.println(Arrays.toString(res));
    }

    static int median = 0;
    public static int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        int arrcopy[] = arr;

        Arrays.sort(arrcopy);
        median = arrcopy[(len - 1) / 2];

        sort(arr, 0, len -1);

        int res[] = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] indexesOfTopElements(int[] array, int top_k) {
        int[] max = new int[top_k];
        int[] maxIndex = new int[top_k];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(maxIndex, -1);

        top: for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < top_k; j++) {
                if (array[i] > max[j]) {
                    for (int x = top_k - 1; x > j; x--) {
                        maxIndex[x] = maxIndex[x - 1];
                        max[x] = max[x - 1];
                    }
                    maxIndex[j] = i;
                    max[j] = array[i];
                    continue top;
                }
            }
        }
        return maxIndex;
    }

    public static boolean stronger(int i, int j, int median) {
        int a = Math.abs(i - median);
        int b = Math.abs(j - median);
        if (a > b) {
            return true;
        } else if (a == b) {
            return i > j ? true : false;
        } else {
            return false;
        }
    }

    static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (stronger(L[i], R[j], median)) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}