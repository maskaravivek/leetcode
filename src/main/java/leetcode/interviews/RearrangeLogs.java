package leetcode.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeLogs {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new ArrayList<>();

        List<String> digitLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] split = logs[i].split(" ");
            if (split[1].charAt(0) >= 48 && split[1].charAt(0) <= 57) {
                digitLogs.add(logs[i]);
            } else {
                String strVal = logs[i].substring(split[0].length());
                letterLogs.add(logs[i]);
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            String[] splitA = a.split(" ");
            String strAVal = a.substring(splitA[0].length());

            String[] splitB = b.split(" ");
            String strBVal = b.substring(splitB[0].length());

            if (strAVal.compareTo(strBVal) == 0) {
                return a.compareTo(b);
            } else {
                return strAVal.compareTo(strBVal);
            }
        });

        queue.addAll(letterLogs);

        String[] result = new String[logs.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            result[idx++] = queue.poll();
        }

        for (String digitLog : digitLogs) {
            result[idx++] = digitLog;
        }

        return result;
    }
}
