// https://leetcode.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "", longestPrefix = "";
        if(strs.length == 0) {
            return "";
        }
        String firstString  = strs[0];
       for(int i = 0; i < firstString.length(); i++) {
            prefix = prefix + firstString.charAt(i);
            for(int j = 0; j< strs.length; j++) {
                if(strs[j].startsWith(prefix)) {
                    continue;
                } else {
                    return longestPrefix;
                }
            }
            longestPrefix = prefix;
        } 
        return prefix;
    }
}