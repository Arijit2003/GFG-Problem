//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
import java.math.BigInteger;
class Solution {
    public static ArrayList<Integer> factorial(int n) {
        // code here
        BigInteger bg=BigInteger.ONE;
        for(int i=2;i<=n;i++){
            bg=bg.multiply(BigInteger.valueOf(i));
        }
        String s=bg.toString();
        ArrayList<Integer> res = new ArrayList<>();
        for(char ch:s.toCharArray()){
            res.add(Integer.valueOf(String.valueOf(ch)));
        }
        return res;
    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends