// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

package leetcode;

class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int count[] = new int[3];

        int j = 0, ans = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;

            while (j < s.length() && count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans++;
                count[s.charAt(j) - 'a']--;
                j++;
            }
            result += ans;
        }
        return result;
    }
}