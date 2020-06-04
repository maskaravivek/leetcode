// https://leetcode.com/problems/long-pressed-name/

package leetcode;

class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int tp = 0;
        int diff = 0;

        while (tp < typed.length()) {
            if (diff <= tp && tp - diff < name.length() && typed.charAt(tp) == name.charAt(tp - diff)) {
                tp++;
            } else if (diff < tp && tp - diff - 1 < name.length() && typed.charAt(tp) == name.charAt(tp - diff - 1)) {
                diff++;
            } else {
                return false;
            }
        }

        return typed.length() - diff == name.length();
    }
}