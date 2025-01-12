//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int res = 0,remainder;
        while(n>1){
            remainder=n%2;
            res+=(remainder+1);
            n/=2;
        }
        return ++res;
    }
}