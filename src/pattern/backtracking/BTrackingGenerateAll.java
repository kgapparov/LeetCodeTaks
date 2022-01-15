package pattern.backtracking;

import java.util.*;

public class BTrackingGenerateAll {
    /*
           Backtracking Solve subset/permutation/combination

           1. Subset
           The problem is simple: Input an array without duplicate numbers, and your algorithm needs to output all
           subsets of these numbers.
     */
    private static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> subset(int[] nums) {
       LinkedList<Integer> track = new LinkedList();
       dfs(nums, 0, track);
       return result;
    }

    private static void dfs(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            //select
            track.add(nums[i]);
            dfs(nums, start+1, track);
            track.pop();
        }
    }

    public static void main(String[] args) {
        subset(new int[]{1,2,3}).forEach(System.out::println);
    }
}
