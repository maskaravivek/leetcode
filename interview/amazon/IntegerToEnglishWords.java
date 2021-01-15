package interview.amazon;

import java.util.*;

class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        int[] divisors = new int[] {1000000000, 1000000, 1000, 100, 10, 1};
        
        String[] term = new String[] {"Billion", "Million", "Thousand", "Hundred"};
        
        List<String> parts = new ArrayList<>();
        
        int idx = 0;
        while(num >= 1000) {
            int q = num / divisors[idx];
            
            if(q > 0) {
                parts.add(getRepForLessThanThousand(q) + " " + term[idx]);
                num = num % divisors[idx];
            }
            idx++;
        }
        
        parts.add(getRepForLessThanThousand(num));
        return String.join(" ", parts).trim();
    }
    
    public String getRepForLessThanThousand(int num) {
        String[] ones = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        String[] tens = new String[] {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        List<String> parts = new ArrayList<>();
        String rep = "";
        if(num >= 100) {
            int q = num / 100;
            
            parts.add(ones[q - 1] + " Hundred");
            num = num % 100;
        }
        
        if(num > 19) {
            int q = num / 10;
            
            parts.add(tens[q - 1]);
            num = num % 10;           
        }
        
        if(num > 0) {
            parts.add(ones[num - 1]);
        }
        
        rep = String.join(" ", parts);
        
        return rep;
    }
}