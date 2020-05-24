import java.util.HashMap;

// https://leetcode.com/problems/number-of-matching-subsequences

class NumberOfMatchingSubsequence {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0;i<words.length; i++) {
            if(isSubsequence(map, words[i], S)) {
                map.put(words[i], true);
                count++;
            } else {
                map.put(words[i], false);
            }
        }
        return count;
    }
    
    public boolean isSubsequence(HashMap<String, Boolean> map, String s, String t) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
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