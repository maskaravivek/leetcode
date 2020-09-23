package leetcode.interviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> results = new HashSet<>();
        generate(results, "", n, 0);
        List<String> resultArr = new ArrayList<>();
        for (String res : results) {
            resultArr.add(res);
        }
        return resultArr;
    }

    public static void generate(Set<String> results, String current, int remaining, int started) {
        if (remaining == 0 && started == 0) {
            results.add(current);
            return;
        }

        if (remaining > 0) {
            if (started > 0) {
                generate(results, current + ")", remaining, started - 1);
                generate(results, current + ")(", remaining - 1, started);
            }
            generate(results, current + "(", remaining - 1, started + 1);
        } else {
            if (started > 0) {
                generate(results, current + ")", remaining, started - 1);
            }
        }
    }
}
