//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int sum=0,len=0,minlen=Integer.MAX_VALUE,st=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            len++;
            while(sum>x){
                minlen=Math.min(len,minlen);
                sum-=arr[st++];
                len--;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}
