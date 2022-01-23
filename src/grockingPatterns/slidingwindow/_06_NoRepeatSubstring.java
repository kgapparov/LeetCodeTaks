package grockingPatterns.slidingwindow;

import java.util.HashMap;

public class _06_NoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        int windowLeft = 0;
        int longestdisctinctLength = 0;
        HashMap<Character, Integer> indexes = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (indexes.containsKey(rightChar)) {
                windowLeft = Math.max(windowLeft, indexes.get(rightChar) + 1);
            }

            indexes.put(rightChar, windowEnd);

            longestdisctinctLength = Math.max(longestdisctinctLength, windowEnd - windowLeft + 1);
        }
        return longestdisctinctLength;
    }
}
