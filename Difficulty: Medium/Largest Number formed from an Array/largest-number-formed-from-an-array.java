//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        if(n==0)return "";
        Arrays.sort(arr,(a,b)->{
            String str1=a+b;
            String str2=b+a;
            return str2.compareTo(str1);
        });
        StringBuilder sb = new StringBuilder("");
        Arrays.stream(arr).forEach(ele->sb.append(ele));
        return sb.toString();
    }
}