//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n) {
        // add your code here
        long[]dp=new long[n+1];
        Arrays.fill(dp,-1);
        return ways(n,dp);
    }
    static long ways(int n,long[]dp){
        if(n<=1)return 1l;
        if(n==2)return 2l;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=(ways(n-1,dp)+ways(n-2,dp)+ways(n-3,dp))%1000000007;
    }
}
