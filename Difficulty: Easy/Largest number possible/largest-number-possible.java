//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int S = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String findLargest(int n, int s) {
        int num=9;
        if(num*n<s)return "-1";
        else if(s==0 && n>1)return "-1";
        String ans="";
        for(int i=0;i<n;i++){
            if(num>s)num=s;
            ans+=(char)(num+48);
            s-=num;
        }
        return ans;
    }
}