//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = S.length;
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(S[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.product(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
     arr[] is the array
*/
class Solution {
    public static long product(long arr[]) {
        // your code here
        long mul=1;
        for(long e:arr){
            mul=(mul*e)%1000000007;
        }
        return mul%1000000007;
    }
}
