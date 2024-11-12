//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        
out.println("~");
}
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int N) {
        //code here
        int n=price.length;
        int[][]dp=new int[N+1][n];
        for(int i=0;i<=N;i++){
            Arrays.fill(dp[i],-1);
        }
        return memo(price,dp,n-1,N);
        
    }
    int memo(int price[],int[][]dp,int idx,int N){
        if(idx==0)return dp[N][idx]=N*price[idx];
        
        if(dp[N][idx]!=-1)return dp[N][idx];
       
        int nottake=0+memo(price,dp,idx-1,N);
        int take=Integer.MIN_VALUE;
        int rodLen=idx+1;
        if(rodLen<=N)take = price[idx]+memo(price,dp,idx,N-rodLen);
        return dp[N][idx] = Math.max(take,nottake);
    }
}