//{ Driver Code Starts
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        Solution ob = new Solution();

        while (T-- > 0) {
            int n = sc.nextInt();
            boolean ans = ob.isPalindrome(n);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isPalindrome(int n) {
        int rev=reverse(n);
        return rev==n;
    }
    public int reverse(int n){
        int sum=0,remainder,digits=countDigits(n)-1;
        while(n>0){
            remainder=n%10;
            sum+=(remainder*(int)Math.pow(10,digits--));
            n/=10;
        }
        return sum;
    }
    public int countDigits(int n){
        if(n==0)return 1;
        int count=0;
        while(n>0){
            count++;
            n/=10;
        }
        return count;
    }
}