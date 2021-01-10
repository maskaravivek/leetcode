package leetcode.strings;

public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(modifyString("?"));
    }

    public static String modifyString(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 26; j++) {
                    if (i - 1 < 0) {
                        if (i + 1 >= arr.length) {
                            arr[i] = 'a';
                        } else if (arr[i + 1] != j + 'a') {
                            arr[i] = (char) (j + 'a');
                        }
                    } else if (i + 1 >= arr.length) {
                        if (arr[i - 1] != j + 'a') {
                            arr[i] = (char) (j + 'a');
                        }
                    } else {
                        if (arr[i - 1] != j + 'a' && arr[i + 1] != j + 'a') {
                            arr[i] = (char) (j + 'a');
                        }
                    }
                }
            }
        }
        return String.valueOf(arr);
    }
}
