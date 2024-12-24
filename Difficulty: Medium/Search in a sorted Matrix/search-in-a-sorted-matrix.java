//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int rows=mat.length,cols=mat[0].length;
        int low=0,high=rows*cols-1,mid,rowNo,colNo;
        while(low<=high){
            mid=(low+high)/2;
            rowNo=mid/cols;
            colNo=mid%cols;
            if(mat[rowNo][colNo]==x)return true;
            else if(mat[rowNo][colNo]<x)low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
