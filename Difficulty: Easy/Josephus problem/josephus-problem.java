//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
    public int josephus(int n, int k){
        //Your code here
        int v=(jos(n,k)+1)%(n+1);
        return (v==0)?1:v;
    }
    public int jos(int n,int k){
        if(n==1)return 0;
        return (jos(n-1,k)+k)%n;
    }

}

