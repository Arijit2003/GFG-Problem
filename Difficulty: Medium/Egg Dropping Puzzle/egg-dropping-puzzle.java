//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int eggs, int floors) {
	    // Your code here
	    int dp[][]=new int[floors+1][eggs+1];
	    for(int i=1;i<=eggs;i++){
	        dp[1][i]=1;
	    }
	    for(int i=1;i<=floors;i++){
	        dp[i][1]=i;
	    }
	    for(int f=2;f<=floors;f++){
	        for(int e=2;e<=eggs;e++){
	            dp[f][e]=Integer.MAX_VALUE;
	            for(int x=1;x<=f;x++){
	                dp[f][e]=Math.min(dp[f][e],1+Math.max(dp[x-1][e-1],dp[f-x][e]));
	            }
	        }
	    }
	    return dp[floors][eggs];
	}
}