//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            if(ob.primeAdjacent(N) == 1)
                System.out.println("Y");
            else
                System.out.println("N");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int primeAdjacent(int N){
        // code here
        if(isPrime(N-1) && isPrime(N+1))return 1;
        return 0;
    }
    static boolean isPrime(int N){
        if(N==2|| N==3)return true;
        if(N==1 || N<=0 || N%2==0 || N%3==0)return false;
        for(int i=5;i*i<=N;i+=6){
            if(N%i==0 || N%(i+2)==0)return false;
        }
        return true;
    }
}