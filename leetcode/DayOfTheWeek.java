package leetcode;

public class DayOfTheWeek {
    // f = k + [(13*m-1)/5] + D + [D/4] + [C/4] - 2*C
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int k = day;
        int m = month < 3 ? month + 10 : month - 2;
        int d = month < 3 ? (year % 100) - 1 : (year % 100);
        int c = year / 100;
        double f = k + Math.floor((13.0 * m - 1.0) / 5.0) + d + Math.floor(d / 4.0) + Math.floor(c / 4.0) - 2.0 * c;
        int rem = (int) f % 7;
        if (rem < 0) {
            rem = 7 + rem;
        }
        return days[rem];
    }
}