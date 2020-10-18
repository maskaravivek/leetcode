// https://leetcode.com/problems/valid-palindrome-ii/

package leetcode;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int sidx = 0;
        int eidx = s.length() - 1;

        while (eidx > sidx) {
            if (s.charAt(sidx) == s.charAt(eidx)) {
                sidx++;
                eidx--;
            } else {
                return palindrome(s.substring(sidx, eidx)) || palindrome(s.substring(++sidx, ++eidx));
            }
        }
        return true;
    }

    public boolean palindrome(String s) {
        System.out.println(s);
        if (s.length() <= 1) {
            return true;
        }
        int sidx = 0;
        int eidx = s.length() - 1;

        while (eidx > sidx) {
            if (s.charAt(sidx) == s.charAt(eidx)) {
                sidx++;
                eidx--;
            } else {
                return false;
            }
        }
        return true;
    }
}