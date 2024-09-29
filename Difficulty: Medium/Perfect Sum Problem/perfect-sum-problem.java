//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	   // if(n==0)return (sum==0)?1:0;
	   // return perfectSum(arr,n-1,sum-arr[n-1])+perfectSum(arr,n-1,sum);
	   int[][]dp=new int [sum+1][n+1];
	   for(int i=0;i<=n;i++){
	       dp[0][i]=1;
	   }
	   for(int i=0;i<=sum;i++){
	       for(int j=1;j<=n;j++){
	           dp[i][j]=dp[i][j-1];
	           if(arr[j-1]<=i){
	               dp[i][j]=(dp[i][j]+dp[i-arr[j-1]][j-1])%1000000007;
	           }
	       }
	   }
	   return dp[sum][n];
	   
	   
	    
	} 
}