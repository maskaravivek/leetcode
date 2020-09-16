package design;

import java.util.Hashtable;
import java.util.TreeMap;

class TimeBasedKey {

    TreeMap<Integer, Integer> treeMap;

    public TimeBasedKey() {
        treeMap = new TreeMap<Integer, Integer>();
    }

    public void add(int time, int value) {
        treeMap.put(time, value);
    }

    public int get(int time) {
        return treeMap.get(treeMap.floorKey(time));
    }
}

public class TimeBasedKeyValue {
    static Hashtable<String, TimeBasedKey> map = new Hashtable<>();

    public TimeBasedKeyValue() {
        map = new Hashtable<>();
    }

    public static void main(String[] args) {

        TimeBasedKeyValue timeBasedKeyValue = new TimeBasedKeyValue();
        timeBasedKeyValue.add("a", 0, 1);
        timeBasedKeyValue.add("a", 2, 2);
        timeBasedKeyValue.add("b", 2, 25);
        timeBasedKeyValue.add("b", 40, 10);

        System.out.println(timeBasedKeyValue.get("a", 1));
        System.out.println(timeBasedKeyValue.get("a", 2));
        System.out.println(timeBasedKeyValue.get("a", 3));
        System.out.println(timeBasedKeyValue.get("a", 10));

        System.out.println(timeBasedKeyValue.get("b", 2));
        System.out.println(timeBasedKeyValue.get("b", 3));
        System.out.println(timeBasedKeyValue.get("b", 10));
        System.out.println(timeBasedKeyValue.get("b", 50));
    }

    public void add(String key, int time, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new TimeBasedKey());
        }
        map.get(key).add(time, value);
    }

    public int get(String key, int time) {
        return map.get(key).get(time);
    }

}