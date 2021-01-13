package interview.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueDeviceNames {
    public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(Arrays.toString(uniqueDeviceNames(new String[]{"switch", "tv", "switch", "tv","switch", "tv"}, 6)));
	}
	
	public static String[] uniqueDeviceNames(String[] deviceNames, int num) {
        Map<String, Integer> map = new HashMap<>();

        String[] results = new String[num];
        for(int i=0; i< num; i++) {
            if(map.containsKey(deviceNames[i])) {
                int lastIndex = map.get(deviceNames[i]);
                results[i] = deviceNames[i] + (lastIndex + 1);
                map.put(deviceNames[i], map.get(deviceNames[i]) + 1);
            } else {
                results[i] = deviceNames[i];
                map.put(deviceNames[i], 0);
            }
        }
        return results;
    }
}
