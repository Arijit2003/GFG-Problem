//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWays(String s) {
        // code here
        return rec(0,s);
    }
    public int rec(int i,String s){
        if(i==s.length())return 1;
        int choice1=0,choice2=0;
        if(s.charAt(i)>='1' && s.charAt(i)<='9'){
            choice1=rec(i+1,s);
        }
        if(i<=s.length()-2){
            String substr=s.substring(i,i+2);
            if(Integer.valueOf(substr)>=10 && Integer.valueOf(substr)<=26){
                choice2=rec(i+2,s);
            }
        }
        return choice1+choice2;
    }
}