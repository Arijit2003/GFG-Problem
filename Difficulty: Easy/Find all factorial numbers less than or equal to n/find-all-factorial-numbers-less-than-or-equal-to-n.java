//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static long[]fact = new long[22];
    static {
        factorial();
    }
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> res= new ArrayList<>();
        int i=1;
        while(i<fact.length && fact[i]<=n){
            res.add(fact[i++]);
        }
        return res;
    }
    static void factorial(){
        fact[0]=1;
        long mul=1;
        for(int i=1;i<fact.length;i++){
            mul*=i;
            fact[i]=mul;
        }
    }
}