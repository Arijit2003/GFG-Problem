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
            String S[] = read.readLine().split(" ");
            
            Long a = Long.parseLong(S[0]);
            Long b = Long.parseLong(S[1]);
            Long m = Long.parseLong(S[2]);
            Long n = Long.parseLong(S[3]);

            Solution ob = new Solution();
            System.out.println(ob.greaterPower(a,b,m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int greaterPower(Long a , Long b , Long m , Long n) {
        // code here
        double x=(a==0l)?0:b*Math.log(a);
        double y=(m==0l)?0:n*Math.log(m);
        if(x==y)return -1;
        return (x>y)?1:0;
        
    }
    
};