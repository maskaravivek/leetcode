// https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        int sum, carryOver = 0, remainder = 0;
        int lastIndex = digits.length-1;
        sum = digits[lastIndex] + 1;
        if(sum < 10) {
            digits[lastIndex] = sum;
            return digits;
        } else {
            carryOver = sum/10;
            remainder = sum%10;
            digits[lastIndex] = remainder;
            for(int i = digits.length -2; i>=0; i--) {
                sum = digits[i] + 1;
                if(sum < 10) {
                    carryOver = 0;
                    remainder = 0;
                    digits[i] = sum;
                    break;
                } else {
                    carryOver = sum/10;
                    remainder = sum%10;
                    digits[i] = remainder;
                }
            }
            if(carryOver > 0) {
                int newDigits[] = new int[digits.length +1];
                newDigits[0] = carryOver;
                for(int j =1; j<newDigits.length;j++) {
                    newDigits[j] = digits[j-1];
                }
                return newDigits;
            } else {
                return digits;
            }
        }
    }
}