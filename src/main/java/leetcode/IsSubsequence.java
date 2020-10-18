package leetcode;

// https://leetcode.com/problems/is-subsequence

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        } 
        int sidx = 0;
        char schar = s.charAt(0);
        for(int i = 0; i<t.length();i++) {
            char c = t.charAt(i);
            if(schar == c) {
                if(sidx == (s.length() - 1)) {
                    return true;
                } else {
                    sidx++;
                    schar = s.charAt(sidx);
                }
            }
        }
        return false;
    }
}