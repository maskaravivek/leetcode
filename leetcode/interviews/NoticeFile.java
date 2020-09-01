package leetcode.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoticeFile {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> lines = new ArrayList<>();

        List<String> hierarchy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            lines.add(line);
            if (!hierarchy.contains(line.split(":")[0])) {
                hierarchy.add(line.split(":")[0]);
            }
        }

        List<String> output = new ArrayList<>();

        String lastId = "0";
        String lastHierarchy = "";

        for (String line : lines) {
            String[] data = line.split(":");
            if (data[1] == hierarchy.get(0)) {
                output.add("0:" + line);
                lastHierarchy = hierarchy.get(0);
                lastId = "0";
            } else {
                output.add(lastId + ":" + line);
                if (!lastHierarchy.equals(data[1])) {
                    lastId = data[0];
                    lastHierarchy = data[1];
                }

            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}