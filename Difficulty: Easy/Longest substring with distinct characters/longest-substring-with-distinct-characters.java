//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubstrDistinctChars(String s) {
        java.util.HashSet<Character> hset = new java.util.HashSet<>();
        int i=0;
        for(i=0;i<s.length();i++){
            if(hset.contains(s.charAt(i))) break;
            hset.add(s.charAt(i));
        }
        int maxct=hset.size(),st=0;
        for(;i<s.length();i++){
            while(hset.contains(s.charAt(i))){
                hset.remove(s.charAt(st));
                st++;
            }
            hset.add(s.charAt(i));
            maxct=Math.max(maxct,hset.size());
        }
        return maxct;
    }
}