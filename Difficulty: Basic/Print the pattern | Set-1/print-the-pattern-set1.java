//{ Driver Code Starts
import java.util.ArrayList;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public ArrayList<Integer> printPat(int n) {
        // write code here
        ArrayList<Integer> res= new ArrayList<>();
        for(int k=n;k>=1;k--){
            for(int i=n;i>=1;i--){
                for(int j=1;j<=k;j++){
                    res.add(i);
                }
            }
            res.add(-1);
        }

    
        return res;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();
        while (t > 0) {
            // Read the integer n for each test case
            int n = sc.nextInt();

            // Create an instance of Solution and call printPat
            Solution sol = new Solution();
            ArrayList<Integer> ans = sol.printPat(n);

            // Print the result list with "$" instead of -1
            for (int num : ans) {

                System.out.print(num + " ");
            }
            System.out.println();
            // System.out.println("~");

            t--;
        }
        sc.close();
    }
}
// } Driver Code Ends