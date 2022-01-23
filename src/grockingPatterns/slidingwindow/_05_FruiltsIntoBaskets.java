package grockingPatterns.slidingwindow;

import java.util.HashMap;

public class _05_FruiltsIntoBaskets {
    /*
Problem Statement#
Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

     */
    public int totalFruit(int[] fruits) {
        int windowLeft = 0;
        int maxFruit = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; ++windowEnd) {
            frequency.put(fruits[windowEnd], frequency.getOrDefault(fruits[windowEnd], 0) + 1);
            while (frequency.size() > 2) {
                frequency.put(fruits[windowLeft], frequency.get(fruits[windowLeft]) - 1);
                if (frequency.get(fruits[windowLeft]) == 0) {
                    frequency.remove(fruits[windowLeft]);
                }
                windowLeft++;
            }
            maxFruit = Math.max(maxFruit, windowEnd - windowLeft + 1);
        }
        return maxFruit;
    }
}
