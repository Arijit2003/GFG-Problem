//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[]){
        int sum=Arrays.stream(arr).sum();
        if(sum%2!=0)return 0;
        if(find(arr,N,sum/2))return 1;
        return 0;
    }
    static boolean find(int[]arr,int N,int target){
        boolean[][]dp = new boolean[target+1][N+1];
        for(int i=0;i<=N;i++)dp[0][i]=true;
        
        for(int t=1;t<=target;t++){
            for(int j=1;j<=N;j++){
                dp[t][j]=dp[t][j-1];
                if(t>=arr[j-1])dp[t][j]=(dp[t][j]||dp[t-arr[j-1]][j-1]);
            }
        }
        return dp[target][N];
    }
}