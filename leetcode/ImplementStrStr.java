package leetcode;

//https://leetcode.com/problems/implement-strstr/

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
        
        if(nLen == 0) {
            return 0;
        }
        
        int cnt = 0;
        for(int i = 0; i<= hLen - nLen; i++) {
            cnt = 0;
            
            for(int j = 0; j< nLen; j++) {
                char hChar = haystack.charAt(i+j);
                char nChar = needle.charAt(j);
                if(hChar == nChar) {
                    cnt++;
                }   
            }
            if(cnt == nLen) {
                return i;
            }
        }
        return -1;
    }
}