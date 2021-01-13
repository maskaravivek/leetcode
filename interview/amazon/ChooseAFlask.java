package interview.amazon;

import java.util.*;

public class ChooseAFlask {

    static class Flask {
        int index;
        int value;

        Flask(int index, int val) {
            this.index = index;
            this.value = val;
        }
    }

    static class PairInt {
        int first, second;

        PairInt() {

        }

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        List<PairInt> markings = new ArrayList<>();
        markings.add(new PairInt(1, 3));
        markings.add(new PairInt(1, 5));
        markings.add(new PairInt(1, 7));
        markings.add(new PairInt(2, 6));
        markings.add(new PairInt(2, 8));
        markings.add(new PairInt(2, 9));
        markings.add(new PairInt(0, 3));
        markings.add(new PairInt(0, 5));
        markings.add(new PairInt(0, 6));
        System.out.println(chooseAFlask(4, 3, 9, new int[]{4, 6, 6, 7}, markings));
    }

    static int index = -1;

    public static int chooseAFlask(int numorders, int flasktypes, int totalMarks, int[] requirements,
            List<PairInt> markings) {
        TreeMap<Integer, List<Integer>> flasks = new TreeMap<>();

        for (PairInt marking : markings) {
            if (!flasks.containsKey(marking.first)) {
                flasks.put(marking.first, new ArrayList<>());
            }

            flasks.get(marking.first).add(marking.second);
        }

        List<Flask> flaskList = new ArrayList<>();

        for (Integer flaskIndex : flasks.keySet()) {
            int cost = 0;
            boolean possible = true;
            for (int i = 0; i < requirements.length; i++) {
                index = -1;
                binarySearch(flasks.get(flaskIndex), 0, flasks.get(flaskIndex).size() -1, requirements[i]);

                if (index == -1) {
                    possible = false;
                    break;
                }

                cost += (flasks.get(flaskIndex).get(index) - requirements[i]);
            }

            if (possible) {
                flaskList.add(new Flask(flaskIndex, cost));
            }
        }

        Collections.sort(flaskList, new Comparator<Flask>(){
            
            @Override
            public int compare(Flask f1, Flask f2) {
                if(f1.value == f2.value) {
                    return f1.index - f2.index;
                }

                return f1.value - f2.value;
            }
        });

        if(flaskList.size() == 0) {
            return -1;
        } else {
            return flaskList.get(0).index;
        }
    }

    public static void binarySearch(List<Integer> markings, int low, int high, int requirement) {
        if (low > high) {
            return;
        }

        int mid = (low + high) / 2;
        if (markings.get(mid) >= requirement) {
            index = mid;
            binarySearch(markings, low, mid - 1, requirement);
        } else {
            binarySearch(markings, mid + 1, high, requirement);
        }
    }
}
