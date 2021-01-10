// https://leetcode.com/problems/making-file-names-unique/

package leetcode;

import java.util.HashMap;
import java.util.Map;

class MakingFileNamesUnique {

    Map<String, Integer> map = new HashMap<>();

    public String[] getFolderNames(String[] names) {
        String result[] = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = getFolderName(names[i]);
        }
        return result;
    }

    public String getFolderName(String name) {
        if (map.containsKey(name)) {
            int suffix = map.get(name) + 1;
            String newName = name + "(" + suffix + ")";

            while (map.containsKey(newName)) {
                suffix++;
                newName = name + "(" + suffix + ")";
            }
            map.put(newName, 0);
            map.put(name, suffix);
            return newName;
        } else {
            map.put(name, 0);
            return name;
        }
    }
}