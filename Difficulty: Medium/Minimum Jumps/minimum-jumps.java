//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int l=0,r=0,jumps=0,maxReach=0;
        while(r<arr.length-1){
            maxReach=0;
            for(int i=l;i<=r;i++){
                maxReach=Math.max(maxReach,arr[i]+i);
            }
            if(maxReach==r)return -1;
            l=r+1;
            r=maxReach;
            jumps++;
           
        }
        return jumps;
    }
}
// // your code here
//         int n=arr.length;
//         if(n<=1) return 0;
//         if(arr[0]==0)return -1;
//         int dp[]=new int[n];
//         Arrays.fill(dp,Integer.MAX_VALUE);
//         dp[0]=0;
//         for(int i=1;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(arr[j]+j>=i){
//                     if(dp[j]!=Integer.MAX_VALUE) {
//                         dp[i]=Math.min(dp[i],1+dp[j]);
//                         break;
//                     }
//                 }
//             }
//         }
//         return dp[n-1]==Integer.MAX_VALUE? -1:dp[n-1];