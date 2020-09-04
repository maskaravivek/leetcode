package leetcode.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DominoesPyramid {
    public static void main(final String[] args) {
        final int[] values = new int[] { 3, 4, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6 };
        System.out.println(solution(values));
    }

    public static String solution(final int[] A) {
        final List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(Arrays.asList(A[i * 2], A[i * 2 + 1]));
        }

        final Stream<List<List<Integer>>> permutations = permutationsLists(list);

        List<List<List<Integer>>> perms = new ArrayList<>();
        permutations.forEach(p -> {
            perms.add(p);
        });

        for (List<List<Integer>> perm : perms) {
            List<List<List<Integer>>> allPerms = generatePerm(perm);

            for (List<List<Integer>> p : allPerms) {
                int arr[] = getArr(p);
                if (arr[0] == arr[3] && arr[1] == arr[4] && arr[2] == arr[7] && arr[3] == arr[8] && arr[4] == arr[9] && arr[5] == arr[10]) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    public static int[] getArr(List<List<Integer>> p) {
        int arr[] = new int[12];
        int idx = 0;
        for (List<Integer> i : p) {
            arr[idx++] = i.get(0);
            arr[idx++] = i.get(1);
        }
        return arr;
    }

    static <T> Stream<List<T>> permutations(final List<T> list) {
        if (list.isEmpty())
            return Stream.empty();
        return IntStream.range(0, list.size()).boxed().flatMap(i -> {
            final T elem = list.get(i);
            final List<T> copy = new LinkedList<>(list);
            copy.remove((int) i);
            final Stream<List<T>> permRest = copy.isEmpty() ? Stream.of(new LinkedList<>()) : permutations(copy);
            return permRest.map(perm -> {
                final List<T> permCopy = new LinkedList<>(perm);
                permCopy.add(0, elem);
                return permCopy;
            });
        });
    }

    @SuppressWarnings("unchecked")
    static <T> Stream<List<T>> permutationsLists(final List<T> list) {
        if (list.size() == 0) {
            return Stream.empty();
        }
        if (!(list.get(0) instanceof List)) {
            return permutations(list);
        } else {
            final List<T> rawList = list;
            final Stream<List<T>> permutationsFirst = permutationsLists((List<T>) list.get(0));

            return permutationsFirst.flatMap(pf -> {
                final Stream<List<T>> permutationsRest = list.size() < 2 ? Stream.of(new LinkedList<>())
                        : permutationsLists(rawList.subList(1, list.size()));
                return permutationsRest.map(pr -> {
                    final List<T> copy = new LinkedList<>(pr);
                    copy.add(0, (T) pf);
                    return copy;
                });
            });
        }
    }

    public static <E> List<List<E>> generatePerm(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePerm(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }
}