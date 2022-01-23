package grockingPatterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
438. Find All Anagrams in a String
Medium

5692

228

Add to List

Share
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */

public class _09_AnagramSubstring {
    public List<Integer> findAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        HashMap<Character, Integer> patternFreq = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternFreq.put(ch, patternFreq.getOrDefault(ch, 0) + 1);
        }
        int match = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); ++windowEnd) {
            char endChar = str.charAt(windowEnd);
            if (patternFreq.containsKey(endChar)) {
                patternFreq.put(endChar, patternFreq.get(endChar) - 1);

                if (patternFreq.get(endChar) == 0) {
                    match++;
                }
            }

            if (match == patternFreq.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (patternFreq.containsKey(leftChar)) {
                    if (patternFreq.get(leftChar) == 0) {
                        match--;
                    }
                    patternFreq.put(leftChar, patternFreq.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}
