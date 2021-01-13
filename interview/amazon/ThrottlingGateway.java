package interview.amazon;

import java.util.HashMap;
import java.util.Map;

public class ThrottlingGateway {
    public static void main (String[] args) throws java.lang.Exception
	{
		int[] requestTimes = new int[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
		System.out.println(throttlingGateway(27, requestTimes));
	}
	
	public static int throttlingGateway(int n, int[] requestTime) {
        Map<Integer, Integer> map = new HashMap<>();

        int dropped = 0;
        for (int i = 0; i < requestTime.length; i++) {
            if(i > 2 && (requestTime[i] == requestTime[i-3])) {
                if(!map.containsKey(requestTime[i]) || map.getOrDefault(i, 0) != i) {
                    map.put(requestTime[i], i);
                    dropped++;
                }
            }

            if(i > 19 && (requestTime[i] - requestTime[i-20] < 10)) {
                if(!map.containsKey(requestTime[i]) || map.getOrDefault(i, 0) != i) {
                    map.put(requestTime[i], i);
                    dropped++;
                }
            }

            if(i > 59 && (requestTime[i] - requestTime[i-60] < 60)) {
                if(!map.containsKey(requestTime[i]) || map.getOrDefault(i, 0) != i) {
                    map.put(requestTime[i], i);
                    dropped++;
                }
            }
        }
        return dropped;
    }
}
