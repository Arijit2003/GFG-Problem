//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        
System.out.println("~");
}
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int mat[][], int N, int M){
        int temp=0,res=-1,max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            temp=searchFirstOne(mat[i],M);
            if(M-temp>max){
                max=M-temp;
                res=i;
            }
        }   
        return res;
    }
    public static int searchFirstOne(int[]arr, int m){
        int i=0,j=m-1,mid=0;
        while(i<=j){
            mid=(i+j)/2;
            if(arr[mid]<1)i=mid+1;
            else j=mid-1;
        }
        return j+1;
    }
}