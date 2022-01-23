package grockingPatterns.slidingwindow;

import java.util.HashMap;

public class _10_MinimumWindowSubstring {
    /*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates)
is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        //frequency of pattern
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        //initial variables
        int windowStart = 0; int minLength = Integer.MAX_VALUE;
        int match = 0; int subStart = 0;
        String result = "";
        for (int windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
            char endChar = s.charAt(windowEnd);

            if (tMap.containsKey(endChar)) {
                tMap.put(endChar, tMap.get(endChar) - 1);
                if (tMap.get(endChar) >= 0) {
                    match++;
                }
            }

            while (match == t.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStart = windowStart;
                    //System.out.println(subStart);
                }

                char leftChar = s.charAt(windowStart++);
                if (tMap.containsKey(leftChar)) {
                    if (tMap.get(leftChar) == 0) {
                        match--;
                    }
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(subStart, subStart + minLength);
    }
}
