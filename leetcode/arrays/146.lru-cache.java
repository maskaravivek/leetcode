package leetcode.arrays;
// https://leetcode.com/problems/lru-cache/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    List<Integer> access;
    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        access = new ArrayList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            addAccessKey(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            map.remove(access.get(0));
            access.remove(0);
        }

        addAccessKey(key);

        map.put(key, value);
    }

    private void addAccessKey(int key) {
        if (access.contains(key)) {
            access.remove(access.indexOf(key));
        }
        access.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
