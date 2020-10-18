// https://leetcode.com/problems/accounts-merge/

package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parents.put(email, email);
                owner.put(email, name);
            }
        }

        for (List<String> account : accounts) {
            String firstEmailParent = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), firstEmailParent);
            }
        }

        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            if (!unions.containsKey(p)) {
                unions.put(p, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                unions.get(p).add(account.get(i));
            }
        }

        List<List<String>> results = new ArrayList<>();

        for (String parent : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(parent));
            emails.add(0, owner.get(parent));
            results.add(emails);
        }

        return results;
    }

    public String find(String s, Map<String, String> parents) {
        return parents.get(s) == s ? s : find(parents.get(s), parents);
    }
}