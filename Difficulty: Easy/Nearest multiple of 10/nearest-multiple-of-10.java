//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int n=str.length();
        char[]arr=str.toCharArray();
        int lastDigit=arr[n-1]-48;
        arr[n-1]='0';
        if(lastDigit<=5) return String.valueOf(arr);
        int carry=1,digit,sum=0;
        for(int i=n-2;i>=0;i--){
            digit=Integer.valueOf(String.valueOf(arr[i]));
            sum=digit+carry;
            arr[i]=(char)((sum%10)+48);
            carry=sum/10;
            if(carry==0) break;
        }
        String res=String.valueOf(arr);
        if(carry==1)return "1"+res;
        return res;
        
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends