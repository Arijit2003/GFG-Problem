//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// avoid space at the starting of the string in "move disk....."
class Hanoi {
    static int count=0;
    public long toh(int n, int from, int to, int aux) {
        // Your code here
        count=0;
        return findtoh(n,from,to,aux);
        
    }
    public long findtoh(int n, int from, int to, int aux){
        if(n==1){
            count++;
            System.out.println("move disk "+n+" from "+"rod "+from+" to "+"rod "+to);
        }
        else{
            findtoh(n-1,from,aux,to);
            System.out.println("move disk "+n+" from "+"rod "+from+" to "+"rod "+to);
            count++;
            findtoh(n-1,aux,to,from);
        }
        return count;
    }
}
