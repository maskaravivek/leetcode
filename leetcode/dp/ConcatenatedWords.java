package leetcode.dp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {

    public static void main(final String[] args) throws java.lang.Exception {
        Instant start = Instant.now();
        String[] arr = Files
                .lines(Paths.get("/Users/vivek/Documents/Projects/asu/coding/leetcode/input/concatenate-words.txt"))
                .toArray(String[]::new);
        ;
        System.out.println(findAllConcatenatedWordsInADict(arr));

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis(); // in millis
        System.out.println("Time taken: " + timeElapsed + " ms");
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }

        });
        List<String> concats = new ArrayList<>();
        List<String> prewords = new ArrayList<>();

        for (String word : words) {
            if (wordBreak(word, prewords)) {
                concats.add(word);
            }
            prewords.add(word);
        }
        return concats;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}