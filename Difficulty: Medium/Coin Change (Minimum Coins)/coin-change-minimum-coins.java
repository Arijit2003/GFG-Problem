//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int n, int sum) {
        // Your code goes here
        int dp[]=new int[sum+1],temp=0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=sum;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i){
                    temp=dp[i-coins[j]];
                    if(temp!=Integer.MAX_VALUE) dp[i]=Math.min(dp[i],1+temp);
                }
            }
        }
        return dp[sum]!=Integer.MAX_VALUE? dp[sum]:-1;
    }
}