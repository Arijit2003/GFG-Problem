//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        sentence=sentence.toLowerCase();
        String arr[]=sentence.split(" ");
        boolean flag=false;
        long val=-1;
        for(String e:arr){
            flag=Pattern.matches("[a-z]+",e);
            if(!flag){
                flag=e.contains("9");
                if(!flag)val=Math.max(val,Long.valueOf(e));
            }
        }
        
        return  val;
    }
}