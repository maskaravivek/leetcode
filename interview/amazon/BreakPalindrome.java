// https://leetcode.com/problems/break-a-palindrome

package interview.amazon;


class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        boolean replaced = false;
        
        char smallestChar = 'z';
        for(int i=0; i< arr.length /2; i++) {
            if(arr[i] < smallestChar) {
                smallestChar = arr[i];
            }
            if(arr[i] > 'a') {
                arr[i] = 'a';
                replaced = true;
                break;
            }
        }
        
        if(smallestChar == 'a' && !replaced) {
            arr[arr.length - 1] = 'b';
            replaced = true;
        }
        
        if(replaced) {
            return String.valueOf(arr);
        } else {
            return "";
        }
    }
}