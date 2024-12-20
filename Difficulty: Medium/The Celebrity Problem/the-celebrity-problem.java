//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length,sum=0;;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
            }
            if(sum==0){
                for(int k=0;k<n;k++){
                    sum+=mat[k][i];
                }
                if(sum==n-1)return i;
            }
        }
        return -1;
    }
}