//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][]dp=new long[N+1][sum+1];
        for(int i=0;i<=N;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j]+=dp[i-1][j];
                if(coins[i-1]<=j) dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[N][sum];
    }
    
}