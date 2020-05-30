package leetcode;
// https://leetcode.com/problems/distribute-candies-to-people

class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int arr[] = new int[num_people];

        int start = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > start) {
                    arr[i] += start;
                    candies -= start;
                    start++;
                } else {
                    arr[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }
        return arr;
    }
}