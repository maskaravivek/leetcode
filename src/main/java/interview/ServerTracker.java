package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ServerTracker {

    public static void main(String[] args) {
        ServerTracker tracker = new ServerTracker();
        System.out.println(tracker.allocate("apibox"));
        System.out.println(tracker.allocate("apibox"));
        tracker.deallocate("apibox1");
        System.out.println(tracker.allocate("apibox"));
        System.out.println(tracker.allocate("sitebox"));
    }

    class Server {
        private int nextAvailable;
        private PriorityQueue<Integer> queue;

        public Server() {
            nextAvailable = 1;
            queue = new PriorityQueue<>((a, b) -> a - b);
        }

        public int getNextAvailableNumber() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }

            int available = nextAvailable;
            nextAvailable++;
            return available;
        }

        public void deallocate(int number) {
            queue.add(number);
        }
    }

    Map<String, Server> map;

    public ServerTracker() {
        map = new HashMap<>();
    }

    public String allocate(String hostName) {
        if (!map.containsKey(hostName)) {
            map.put(hostName, new Server());
        }

        return hostName + "" + map.get(hostName).getNextAvailableNumber();
    }

    public void deallocate(String host) {
        String num = "";
        String hostName = "";
        char[] arr = host.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num += arr[i];
            } else {
                hostName += arr[i];
            }
        }

        map.get(hostName).deallocate(Integer.parseInt(num));
    }
}
