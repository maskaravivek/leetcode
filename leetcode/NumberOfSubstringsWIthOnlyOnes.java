package leetcode;

public class NumberOfSubstringsWIthOnlyOnes {
    public int numSub(String s) {
        int result = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                result += permutation(count);
                result += count = 0;
            }
        }
        return result;
    }

    public int permutation(int num) {
        int ans = (num * (num + 1)) / 2;
        ans = ans % 1000000007;
        return ans;
    }
}


 + 