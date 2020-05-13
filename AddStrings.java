import java.util.*;
import java.lang.*;
import java.io.*;

class AddStrings {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(addStrings("11", "1"));
    }

    public static String addStrings(String num1, String num2) {
        int num1Idx = num1.length() - 1;
        int num2Idx = num2.length() - 1;

        int carryOver = 0, num, sum;

        String sumStr = "";
        while (num1Idx >= 0 && num2Idx >= 0) {
            int num1Num = num1.charAt(num1Idx) - 48;
            int num2Num = num2.charAt(num2Idx) - 48;
            sum = num1Num + num2Num + carryOver;
            carryOver = sum / 10;
            num = sum % 10;
            sumStr = sumStr + String.valueOf(num);
            num1Idx --;
            num2Idx --;
        }

        while (num1Idx >= 0) {
            int num1Num = num1.charAt(num1Idx) - 48;
            sum = num1Num + carryOver;
            carryOver = sum / 10;
            num = sum % 10;
            sumStr = sumStr + String.valueOf(num);
            num1Idx --;
        }

        while (num2Idx >= 0) {
            int num2Num = num2.charAt(num2Idx) - 48;
            sum = num2Num + carryOver;
            carryOver = sum / 10;
            num = sum % 10;
            sumStr = sumStr + String.valueOf(num);
            num2Idx --;
        }

        if (carryOver != 0) {
            sumStr = sumStr + carryOver;
        }
        return new StringBuilder(sumStr).reverse().toString();
    }
}