//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
        int tail[]=new int[n];
        tail[0]=a[0]; 
        int len=1;
        for(int i=1;i<n;i++){
            if(a[i]>tail[len-1]){
                tail[len]=a[i]; len++;
            }else{
                tail[getCeilIdx(tail,0,len-1,a[i])]=a[i];
            }
        }
        return len;
    }
    static int getCeilIdx(int[]res,int l,int r,int e){
        int m;
        while(r>l){
            m=l+(r-l)/2;
            if(res[m]>=e) r=m;
            else l=m+1;
        }
        return r;
    }
}