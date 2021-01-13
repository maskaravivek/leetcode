package interview.amazon;

import java.util.Arrays;

public class WinningSequence {
    public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(Arrays.toString(winningSequence(5, 3, 10))); // => [9, 10, 9, 8, 7]
		System.out.println(Arrays.toString(winningSequence(7, 3, 10))); // => [9, 10, 9, 8, 7, 6 ,5]
		System.out.println(Arrays.toString(winningSequence(10, 3, 10))); // => [8, 9, 10, 9, 8, 7, 6, 5, 4, 3]
		System.out.println(Arrays.toString(winningSequence(15, 3, 10))); // => [3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3]
		System.out.println(Arrays.toString(winningSequence(16, 3, 10))); // => null
		//
		System.out.println(Arrays.toString(winningSequence(5, 1, 3))); // => [1, 2, 3, 2, 1]
		System.out.println(Arrays.toString(winningSequence(3, 1, 3))); // => [2, 3, 2]
		//
		System.out.println(Arrays.toString(winningSequence(5, 9, 10))); // => null
		System.out.println(Arrays.toString(winningSequence(5, 10, 10))); // => null
	}
	
	public static int[] winningSequence(int n, int lowerBound, int upperBound) {
        if (n > ((upperBound - lowerBound) * 2 + 1)) {
            return null;
        }

        int starting = upperBound - 1;

        while ((upperBound - starting) + 1 + (upperBound - lowerBound) < n) {
            starting--;
        }

        int[] res = new int[n];

        int i = 0;
        while (starting < upperBound) {
            res[i++] = starting++;
        }

        res[i++] = upperBound;
		starting--;
        while (i < n) {
            res[i++] = starting--;
        }

        return res;
    }
}
