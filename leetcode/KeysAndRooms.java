// https://leetcode.com/problems/keys-and-rooms

package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visit(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    public void visit(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        List<Integer> keys = rooms.get(room);
        for (Integer key : keys) {
            if (!visited.contains(key)) {
                visited.add(key);
                if(rooms.size() == visited.size()) {
                    return;
                }
                visit(key, rooms, visited);
            }
        }
    }
}