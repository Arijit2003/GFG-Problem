//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    
    static int nCr(int n, int r){
        int [][]dp=new int[r+1][n+1];
        for(int i=0;i<=r;i++){
            Arrays.fill(dp[i],-1);
        }
        return getRes(n,r,dp);
    }
    static int getRes(int n,int r,int[][]dp){
        if(n<r)return 0;
        if(r==0||n==r)return 1;
        if(dp[r][n]!=-1)return dp[r][n];
        return dp[r][n]=(getRes(n-1,r-1,dp)+getRes(n-1,r,dp))%1000000007;
    }
    
    
}