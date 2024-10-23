//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());

        while (t-- > 0) {
            String line = scanner.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxIndexDiff(nums));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find the maximum index difference.
    int maxIndexDiff(int[] arr) {
        // Your code here
        int n=arr.length,i=0,j=0,maxDiff=-1;
        int leftMin[]=new int[n];
        int rightMax[]=new int[n];
        leftMin[0]=arr[0]; rightMax[n-1]=arr[n-1];
        for(int k=1;k<n;k++){
            leftMin[k]=Math.min(leftMin[k-1],arr[k]);
        }
        for(int k=n-2;k>=0;k--){
            rightMax[k]=Math.max(rightMax[k+1],arr[k]);
        }
        while(j<n){
            if(leftMin[i]<=rightMax[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }else i++;
        }
        return maxDiff;
    }
}