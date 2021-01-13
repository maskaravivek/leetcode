package interview.amazon;

import java.util.*;

class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        List<List<String>> results = new ArrayList<>();
        String prefix = "";
        int start = 0, bsStart = 0;
        for(int i=0; i< searchWord.length(); i++) {
            prefix += searchWord.charAt(i);
            
            start = lower_bound(bsStart, products, prefix);
            
            List<String> result = new ArrayList<>();
            for(int j= start; j< Math.min(products.length, start + 3); j++) {
                if(products[j].length() < prefix.length() || !products[j].startsWith(prefix)) {
                    break;
                }
                result.add(products[j]);
            }
            results.add(result);
        }
        return results;
    }
    
    public int lower_bound(int start, String[] products, String prefix) {
        int low = start, high = products.length, mid;
        while(low < high) {
            mid = (low + high) /2;
            
            if(products[mid].compareTo(prefix) >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }   
        return low;
    }
}