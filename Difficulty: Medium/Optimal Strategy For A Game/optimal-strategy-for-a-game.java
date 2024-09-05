//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class OptimalStrategy {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting the elements
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            // calling the countMaximum() method of class solve
            System.out.println(new solve().maximumAmount(arr, n));
        }
    }
}
// } Driver Code Ends



class solve {
    // Function to find the maximum possible amount of money we can win.
    static long maximumAmount(int arr[], int N) {
        // Your code here
        int[][]dp=new int[N][N];
        if(N==1) return arr[0];
        if(N%2!=0){
            for(int i=0;i<N;i++){
                dp[i][i]=arr[i];
            }
            for(int gap=2;gap<N;gap++){
                for(int i=0;i+gap<N;i++){
                    int j=i+gap;
                    dp[i][j]=Math.max(
                        arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),
                        arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
                }
            }
          
        }
        else{
            for(int i=0;i<N-1;i++){
                dp[i][i+1]=Math.max(arr[i],arr[i+1]);
            }
            for(int gap=3;gap<N;gap++){
                for(int i=0;i+gap<N;i++){
                    int j=i+gap;
                    dp[i][j]=Math.max(
                        arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),
                        arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
                }
            }
        }
        
        return dp[0][N-1];
    }
}
