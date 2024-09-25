//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingGeek(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String jumpingGeek(int N) {
        // code here
        if(N==0||N==1||N==3||N==6)return "yes";
        return (getN(N,1,6)||getN(N,3,6)||getN(N,6,6))?"yes":"no";
    }
    static boolean getN(int an, int az, int d ){
        double dv=((an-az)/(double)d)+1;
        int iv=((an-az)/d)+1;
        return (dv==iv);
    }
};