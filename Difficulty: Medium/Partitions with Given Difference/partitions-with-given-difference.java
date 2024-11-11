//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int val=Arrays.stream(arr).sum()-d;
        if(val%2!=0 || val<0)return 0;
        int sum=val/2;
        int[][]dp=new int[sum+1][n+1];
        for(int i=0;i<=sum;i++){
            Arrays.fill(dp[i],-1);
        }
        // for(int i=0;i<=n;i++){
        //     dp[0][i]=1;
        // }
        // for(int i=1;i<=sum;i++){
        //     dp[i][0]=0;
        // }
        // if(arr[0]==0)dp[0][1]=2;
        // else dp[0][1]=1;
        // if(arr[0]!=0 && arr[0]<=sum)dp[arr[0]][1]=1;
        // for(int i=1;i<=sum;i++){
        //     for(int j=1;j<=n;j++){
        //         dp[i][j]=dp[i][j-1];
        //         if(i>=arr[j-1])dp[i][j]=(dp[i][j]+dp[i-arr[j-1]][j-1])%1000000007;
        //     }
        // }
        // return dp[sum][n];
        return countSubsets(arr,n,sum,dp);
    }
    public static int countSubsets(int[]arr,int n, int target,int[][]dp){
        if(n==0){
            if(target==0)return dp[target][n]=1;
            else return dp[target][n]=0;
        }
        if(dp[target][n]!=-1)return dp[target][n];
        dp[target][n]=countSubsets(arr,n-1,target,dp)%1000000007;
        if(target>=arr[n-1])dp[target][n]=(dp[target][n] +
        countSubsets(arr,n-1,target-arr[n-1],dp))%1000000007;
        
        return dp[target][n];
    }
}
        
