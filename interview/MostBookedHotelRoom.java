// https://leetcode.com/discuss/interview-question/421787/

package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostBookedHotelRoom {

    public static void main(String[] args) {
        System.out.println(mostBooked(new String[] { "+5A", "+3E", "+3E", "-1A", "+4F", "+5A", "-3E" }));
    }

    public static String mostBooked(String[] bookings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].charAt(0) == '+') {
                String room = bookings[i].substring(1);
                map.put(room, map.getOrDefault(room, 0) + 1);
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            int aBookings = map.get(a);
            int bBookings = map.get(b);

            if (aBookings == bBookings) {
                int floorA = a.charAt(0) - '0';
                int floorB = b.charAt(0) - '0';

                char roomA = a.charAt(1);
                char roomB = b.charAt(1);

                if (floorA == floorB) {
                    return roomA - roomB;
                } else {
                    return floorA - floorB;
                }
            } else {
                return bBookings - aBookings;
            }
        });

        queue.addAll(map.keySet());

        return queue.poll();
    }
}
