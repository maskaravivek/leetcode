package interview.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Question1 {

  static int solution(String[] A) {
    Set<String> set = new HashSet<>();

    for (int i = 0; i < A.length; i++) {
        if (A[i].charAt(0) == '+') {
            String room = A[i].substring(1);
            set.add(room);
        }
    }

    return set.size();
  }

  public static void main(String[] args) {
    // Read from stdin, solve the problem, and write the answer to stdout.
    Scanner in = new Scanner(System.in);
    String raw = in.next();
    String removedBrackets = raw.substring(1, raw.length() - 1);
    String[] withQuotes = removedBrackets.split(",");
    String[] A =
        Arrays.asList(withQuotes).stream()
            .map(s -> s.substring(1, s.length() - 1))
            .toArray(String[]::new);
    System.out.print(solution(A));
  }
}