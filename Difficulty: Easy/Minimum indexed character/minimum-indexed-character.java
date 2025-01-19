//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function template for JAVA

class Solution {
    // Function to find the minimum indexed character.
    public static int minIndexChar(String s1, String s2) {
        // Your code here
        HashSet<Character> hset = new HashSet<>();
        for(Character c:s2.toCharArray()) hset.add(c);
        
        for(int i=0;i<s1.length();i++){
            if(hset.contains(s1.charAt(i))) return i;
        }
        return -1;
        
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;

            String s1 = sc.next();
            String s2 = sc.next();

            int res = new Solution().minIndexChar(s1, s2);
            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends