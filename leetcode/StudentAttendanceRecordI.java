package leetcode;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        char arr[] = s.toCharArray();

        int acount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                acount++;
            }

            if (i > 1 && arr[i] == 'L' && arr[i - 1] == 'L' && arr[i - 2] == 'L') {
                return false;
            }
        }

        return acount > 1 ? false : true;
    }
}