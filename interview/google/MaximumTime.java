// https://leetcode.com/discuss/interview-question/396769/

package interview.google;

public class MaximumTime {

    public static void main(String[] args) {
        solution("23:5?");// 23:59
        solution("2?:22");// 23:22
        solution("0?:??");// 09:59
        solution("1?:??");// 19:59
        solution("?4:??");// 14:59
        solution("?3:??");// 23:59
        solution("??:??");// 23:59
        solution("?4:5?"); // 14:59
        solution("?4:??"); // 14:59
        solution("?3:??"); // 23:59
        solution("23:5?"); // 23:59
        solution("2?:22"); // 23:22
        solution("0?:??"); // 09:59
        solution("1?:??"); // 19:59
        solution("?4:0?"); // 14:09
        solution("?9:4?"); // 19:49

        solution("2?:?8"); // 19:49
        solution("1?:?2"); // 19:49
    }

    public static String solution(String time) {
        char[] arr = time.toCharArray();

        if (arr[0] == '?' && arr[1] == '?') {
            arr[0] = '2';
            arr[1] = '3';
        } else if (arr[0] == '?') {
            if (arr[1] >= '0' && arr[1] <= '3') {
                arr[0] = '2';
            } else {
                arr[0] = '1';
            }
        } else if (arr[1] == '?') {
            if (arr[0] == '0' || arr[0] == '1') {
                arr[1] = '9';
            } else {
                arr[1] = '3';
            }
        }

        if (arr[3] == '?' && arr[4] == '?') {
            arr[3] = '5';
            arr[4] = '9';
        } else if (arr[3] == '?') {
            arr[3] = '5';
        } else if (arr[4] == '?') {
            arr[4] = '9';
        }

        System.out.println(String.valueOf(arr));
        return String.valueOf(arr);
    }
}
