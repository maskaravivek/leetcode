package foobar;

public class LovelyLuckyLAMBs {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(143));
    }

    public static int solution(int total_lambs) {
        if (total_lambs < 10 || total_lambs > 1000000000) {
            return 0;
        } else {
            return largestFibonacci(total_lambs) - largestPowerOf2(total_lambs);
        }
    }

    static int largestPowerOf2(int total_lambs) {
        int l = 0, sum = 0, hench = 0;
        while (sum + l * 2 <= total_lambs) {
            if (l == 0) {
                l = 1;
            } else
                l = l * 2;
            sum += l;
            hench++;
        }
        if (total_lambs - sum >= l + l / 2) {
            return hench + 1;
        } else
            return hench;
    }

    static int largestFibonacci(int total_lambs) {
        int l = 0, prev = 1, sum = 0, hench = 0;
        while (sum + l + prev <= total_lambs) {
            l = l + prev;
            prev = l - prev;
            sum += l;
            hench++;
        }
        return hench;
    }
}