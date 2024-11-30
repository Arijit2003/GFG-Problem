//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String a, String b) {

        // Your code here
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        // Your code here
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            h1.put(a.charAt(i),1+h1.getOrDefault(a.charAt(i),0));
            h2.put(b.charAt(i),1+h2.getOrDefault(b.charAt(i),0));
        }
        if(h1.equals(h2)) return true;
        else return false;
    }
}