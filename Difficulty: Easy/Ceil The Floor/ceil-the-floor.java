//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor=Integer.MIN_VALUE, ceil=Integer.MAX_VALUE;
        for(int e:arr){
            if(e<=x)floor=Math.max(floor,e);
            if(e>=x)ceil=Math.min(ceil,e);
        }
        int res[]=new int[2];
        res[0]=(floor==Integer.MIN_VALUE)?-1:floor;
        res[1]=(ceil==Integer.MAX_VALUE)?-1:ceil;
        return res;
    }
}
