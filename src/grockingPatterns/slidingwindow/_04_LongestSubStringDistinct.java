package grockingPatterns.slidingwindow;

import java.util.HashMap;

/*

Given a string, find the length of the longest substring in it with no more than K distinct characters.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
Example 4:

Input: String="cbbebi", K=10
Output: 6
Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".

 */


public class _04_LongestSubStringDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> characterFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
            while (characterFrequency.size() > k) {
                char leftChar = s.charAt(windowStart++);
                characterFrequency.put(leftChar, characterFrequency.getOrDefault(leftChar, 0) - 1);
                if (characterFrequency.get(leftChar) == 0) {
                    characterFrequency.remove(leftChar);
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart+1);
        }
        return maxLength == Integer.MIN_VALUE ? 0  : maxLength;
    }
}
