//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s = in.readLine().trim();
            Solution ob = new Solution();
            out.println(ob.isDivisible(s) ? "true" : "false");

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isDivisible(String s) {
        // code here
        
        int n=s.length(),pos=0,oddset=0,evenset=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                pos=i;
                break;
            }
        }
        if(pos!=0 && pos==n-1)return false;
        for(int i=pos;i<n;i++){
            if(s.charAt(i)=='1'){
                if((i-pos+1)%2==0)evenset++;
                else oddset++;
            }
        }
        return Math.abs(evenset-oddset)%3==0;
    }
}