package foobar;

public class TheCakeIsNotALie {

    public static int solution(String s) {
        int maxSlices = -1;
        int length = s.length();
        for (int idx = length; idx > 0; idx--) {
            int split = length / idx;
            if (split * idx == length) {
                boolean isValid = true;
                String subStr = s.substring(0, split);
                for (int i = 1; i < idx; i++) {
                    int startIdx = i * split;
                    int endIdx = i * split + split;
                    if (!s.substring(startIdx, endIdx).equals(subStr)) {
                        isValid = false;
                        break;
                    }

                }
                if (isValid) {
                    maxSlices = idx;
                    break;
                }

            }

        }
        return maxSlices;
    }
}