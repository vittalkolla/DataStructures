package SlidingWindow;

import java.util.*;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
public class LongestSubStringKDistinct {
    public static int longestSubString(String str, int K) {

        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, len = 0;

        for (int end = 0; end < str.length(); end++) {
            freqMap.put(str.charAt(end), freqMap.getOrDefault(str.charAt(end), 0)+1);
            while(freqMap.size() > K){
                char leftChar = str.charAt(start);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                if(freqMap.get(leftChar) == 0){
                    freqMap.remove(leftChar);
                }
                start++;
            }
            len = Math.max(len, end-start+1);
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "araaci";
        System.out.println(longestSubString(str, 2));
    }
}
