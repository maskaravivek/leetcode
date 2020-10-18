// https://leetcode.com/problems/hamming-distance/

package leetcode;

class HammingDistance {
    public int hammingDistance(int x, int y) {
        String xs = Integer.toBinaryString(x);
        String ys = Integer.toBinaryString(y);
        
        int diff = Math.abs(xs.length() - ys.length());
        
        if(xs.length() > ys.length()) {
            for(int i=0; i< diff; i++) {
                ys = "0" + ys;
            }
        } else if(ys.length() > xs.length()) {
            for(int i=0; i< diff; i++) {
                xs = "0" + xs;
            }
        }
        
        int count = 0;
        for(int i=0; i< xs.length(); i++) {
            if(xs.charAt(i) != ys.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}