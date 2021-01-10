package interview.google;

import java.util.PriorityQueue;

class Question2 {

  public static String solution(String T) {
    char[] arr = T.toCharArray();

    if (arr[0] == '?') {
      int hour = 2;
      if (arr[1] != '?' && arr[1] > '3') {
        hour = 1;
      }
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '?') {
          arr[i] = (char) ('0' + hour);
        }
      }
    } else if (arr[1] == '?') {
      int hour = arr[0] == '2' ? ((arr[3] == '?' || arr[4] == '?') ? 3 : 5) : 9;

      if (arr[0] == '1' || arr[0] == '0') {
        if (arr[3] != '?') {
          hour = 9;
        } else {
          hour = 5;
        }
      } else {
        hour = 3;
      }

      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '?') {
          arr[i] = (char) ('0' + hour);
        }
      }
    } else if (arr[3] == '?') {
      int time = 5;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '?') {
          arr[i] = (char) ('0' + time);
        }
      }
    } else if (arr[4] == '?') {
      arr[4] = '9';
    }

    return String.valueOf(arr);
  }

  public static String solution2(String T) {
    int[] maxTime = new int[] { 2, 9, 0, 5, 9 };
    if (T.charAt(1) > '3') {
      maxTime[0] = 1;
    }
    if (T.charAt(0) == '2') {
      maxTime[1] = 3;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      return maxTime[a] - maxTime[b];
    });
    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '?')
        pq.add(i);
    }
    if (pq.isEmpty()) {
      return T;
    }
    int index = pq.remove();
    char ans = (char) (maxTime[index] + '0');
    StringBuilder res = new StringBuilder(T);
    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '?') {
        res.replace(i, i + 1, ans + "");
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    solution("2?:?8");
    solution("1?:?2");
    System.out.println(solution("?5:58"));
  }
}