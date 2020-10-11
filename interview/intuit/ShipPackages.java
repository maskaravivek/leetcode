package interview.intuit;

import java.io.*;
import java.util.*;


public class ShipPackages {
    // If you need extra classes, you can define them privately here within class
    // Solution

    // Prints to standard output.
    static void findStartAndEndLocations(String[][] pairs) {

        Set<String> nodes = new HashSet<>();
        Map<String, List<String>> bottom = new HashMap<>();
        Map<String, List<String>> top = new HashMap<>();
        // Your code here.
        for (String[] pair : pairs) {
            String s = pair[0];
            String d = pair[1];

            nodes.add(s);
            nodes.add(d);

            if (!bottom.containsKey(s)) {
                bottom.put(s, new LinkedList<>());
            }

            bottom.get(s).add(d);

            if (!top.containsKey(d)) {
                top.put(d, new LinkedList<>());
            }

            top.get(d).add(s);
        }

        TreeMap<String, List<String>> resultMap = new TreeMap<>();

        for (String node : nodes) {
            if (!top.containsKey(node) && bottom.containsKey(node)) {
                Set<String> results = new HashSet<>();
                traverse(bottom, node, results);

                List<String> resultArr = new ArrayList<>(results);

                Collections.sort(resultArr);

                resultMap.put(node, resultArr);
            }
        }

        for(String key: resultMap.keySet()) {
            System.out.println(key + ": " + String.join(" ", resultMap.get(key)));
        }
    }

    static void traverse(Map<String, List<String>> bottom, String node, Set<String> results) {
        if(!bottom.containsKey(node)) {
            results.add(node);
            return;
        }
        List<String> successors = bottom.get(node);
        
        for(String successor: successors) {
            traverse(bottom, successor, results);
        }
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        List<String[]> arg1 = new ArrayList<String[]>();

        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                arg1.add(line.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String[][] pairs = arg1.toArray(new String[arg1.size()][]);

        findStartAndEndLocations(pairs);
    }
}
