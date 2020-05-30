package leetcode;

// https://leetcode.com/problems/length-of-last-word

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int len = split.length;
        if(len == 0) {
            return 0;
        } else {
            return split[len-1].length();
        }
    }
}