package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int arr[] = new int[bloomDay.length - k + 1];

        int idx = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bloomDay.length; i++) {

            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }

            while (!queue.isEmpty() && bloomDay[queue.peekLast()] < bloomDay[i]) {
                queue.removeLast();
            }

            queue.addLast(i);

            if (i >= k - 1) {
                arr[idx++] = bloomDay[queue.peekFirst()];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        System.out.println(Arrays.toString(map.entrySet().toArray()));

        ArrayList<Integer> noList = new ArrayList();

        int wait = Integer.MIN_VALUE;
        int cnt = 0;
        for (Integer key : temp.keySet()) {
            if (noList.contains(key)) {
                continue;
            }

            wait = Math.max(wait, temp.get(key));
            cnt++;
            if (cnt == m) {
                break;
            }
            for (int i = key - k + 1; i < key + k; i++) {
                noList.add(i);
            }
        }
        return cnt == m ? wait : -1;
    }
}