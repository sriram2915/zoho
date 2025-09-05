import java.util.*;
// find the minimum window in string S which will contain all the characters in string T in complexity O(n).
// Input Format
// The first line of input contains the string S.
// The second line of input contains the string T.
// Output Format
// Print the minimum window in S which will contain all the characters in T. If no such window exists, print an empty string "".

public class Question04 {
    public static void main(String[] args) {
        String s = "aaabbbccc";
        String t = "abc";

        System.out.println(minWindow(s, t));

        // String sb="";
        // int min = s.length();
        // int left = 0;
        // System.out.println(containsA(s, t));
        
        // for(int right=0;right<s.length();right++){
            
        //     sb+=s.charAt(right);
        //     char temp='#';
        //     while(containsA(sb,t)){
        //         System.out.println(sb);
        //         temp = sb.charAt(left);
        //         left++;
        //         sb = sb.substring(left,right);
        //     }
        //    if(temp!='#') sb = temp+sb;
        //     System.out.println(sb+" "+sb.length());
        //     if(containsA(sb,t)){
        //         if(min<=sb.length()) System.out.println(sb);
        //     }
        // }
    }
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        // frequency map for t
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int required = target.size();
        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // ans[0] = length, ans[1] = left, ans[2] = right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if (target.containsKey(c) && windowCounts.get(c).intValue() == target.get(c))
                formed++;

            while (left <= right && formed == required) {
                // update smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                char ch = s.charAt(left);
                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if (target.containsKey(ch) && windowCounts.get(ch) < target.get(ch))
                    formed--;
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    // static boolean containsA(String sb,String t){
    //     int j=0;
    //     for(int i=0;i<sb.length();i++){
    //         if( sb.charAt(i)==t.charAt(j)){
    //             j++;
    //             if(j==t.length()) return true; 
    //         }
    //     }
    //     return false;
    // }

}
