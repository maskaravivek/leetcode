//https://leetcode.com/problems/valid-parentheses/
class Solution {
    
    public boolean isValid(String s) {
        int len = s.length();
        if(len%2==1) {
            return false;
        }
        char arr[] = new char[len];
        int index = 0;
        for(int i =0; i< len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                arr[index++] = c;
            } else {
                index = index -1;
                if(index < 0) {
                    return false;
                }else if((arr[index] == '(' && ')' == c)
                  || (arr[index] == '{' && '}' == c)
                  || (arr[index] == '[' && ']' == c)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return index == 0;
    }
    
    
}