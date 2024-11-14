//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int breakpoint=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                breakpoint=i;break;
            }
        }
        if(breakpoint==-1){
            java.util.Arrays.sort(arr);
            return;
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[breakpoint]){
                int temp=arr[i];
                arr[i]=arr[breakpoint];
                arr[breakpoint]=temp;
                break;
            }
        }
        java.util.Arrays.sort(arr,breakpoint+1,arr.length);
        
        
    }
}