//https://leetcode.com/problems/palindrome-number/

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        char ch[]=number.toCharArray();  
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){  
            rev+=ch[i];  
        }  
        return rev.equals(number);  
    }
}