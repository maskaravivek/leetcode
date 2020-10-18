package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(final String[] args) throws java.lang.Exception {
        String emails[] = new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < emails.length; i++) {
            String split[] = emails[i].split("@");
            String email = getEmail(split[0]);
            System.out.println(email);
            Set<String> entry = map.getOrDefault(split[1], new HashSet<>());
            entry.add(email);
            map.put(split[1], entry);
        }

        int count = 0;
        for (String key : map.keySet()) {
            count += map.get(key).size();
        }
        return count;
    }

    public static String getEmail(String s) {
        s = s.replace(".", "");
        int idx = s.indexOf("+");
        if (idx > 0) {
            return s.substring(0, idx);
        } else {
            return s;
        }
    }
}