//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int count=0,left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]<target)left++;
            else if(arr[left]+arr[right]>target)right--;
            else{
                int cnt1=0,ele1=arr[left],cnt2=0, ele2=arr[right];
                while(left<=right && arr[left]==ele1){
                    cnt1++; left++;
                }
                while(left<=right && arr[right]==ele2){
                    cnt2++;right--;
                }
                if(ele1==ele2)count+=(cnt1*(cnt1-1))/2;
                else count+=(cnt1*cnt2);
            }
        }
        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends