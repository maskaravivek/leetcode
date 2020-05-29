import java.util.*;
import java.lang.*;
import java.io.*;

class AddBinary {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;

        int carryOver = 0, num, sum;

        String sumStr = "";
        while (aIdx >= 0 && bIdx >= 0) {
            int aNum = a.charAt(aIdx) - 48;
            int bNum = b.charAt(bIdx) - 48;
            sum = aNum + bNum + carryOver;
            carryOver = sum / 2;
            num = sum % 2;
            sumStr = sumStr + String.valueOf(num);
            aIdx --;
            bIdx --;
        }

        while (aIdx >= 0) {
            int aNum = a.charAt(aIdx) - 48;
            sum = aNum + carryOver;
            carryOver = sum / 2;
            num = sum % 2;
            sumStr = sumStr + String.valueOf(num);
            aIdx --;
        }

        while (bIdx >= 0) {
            int bNum = b.charAt(bIdx) - 48;
            sum = bNum + carryOver;
            carryOver = sum / 2;
            num = sum % 2;
            sumStr = sumStr + String.valueOf(num);
            bIdx --;
        }

        if (carryOver != 0) {
            sumStr = sumStr + carryOver;
        }
        return new StringBuilder(sumStr).reverse().toString();
    }
}