//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k) count++;
        }
  
        int i=0,j=0;
        if(count==1 || count==1)return 0;
        int min=Integer.MAX_VALUE;
        int curr=0;
        while(j<count){
            if(arr[j]>k)curr++;
            j++;
        }
        min=Math.min(min,curr);
        for(;j<n;j++){
            if(arr[j]>k)curr++;
            if(arr[i]>k)curr--;
            i++;
            // if(curr==0)continue;
            min=Math.min(min,curr);
        }
        return min;
    }
    
    
}
