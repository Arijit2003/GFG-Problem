//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getVol(A,B));
        }
    }
}
// } Driver Code Ends




class Solution {
    static long getVol(int A, int B) {
        // code here
        double l=(A-Math.sqrt(A*A-24*B))/12;
        double V=l*(B/2.0-l*(A/4.0-l));
        return (long)V; 
    }
};