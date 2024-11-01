//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        String temp;
        while(true){
            temp=remove(s);
            if(temp.length()==s.length()) break;
            s=temp;
        }
        return s;
        
    }
    String remove(String s){
        int i=0,j,n=s.length();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            j=i+1;
            while(j<n && s.charAt(i)==s.charAt(j))j++;
            if(i+1==j)sb.append(String.valueOf(s.charAt(i)));
            i=j;
        }
        return sb.toString();
    }
}