package random;

public class CheckPowerOfNumber {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(check(3, 27));
        System.out.println(check(4, 18));
    }

    // check if y is power of x
    public static boolean check(int x, int y) {
        int res = (int) Math.log(y) / (int) Math.log(x);

        double res2 = Math.log(y) / Math.log(x);

        return res == res2;
    }
}
