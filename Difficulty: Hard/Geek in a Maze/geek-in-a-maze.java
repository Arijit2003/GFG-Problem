//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static class Move{
        int row,col,up,down;
        Move(int r,int c,int u, int d){
            row=r; col=c; up=u; down=d;
        }
    }
    
    public static boolean isSafe(char [][]mat,int n, int m, int i, int j){
        if(i<n && i>=0 && j<m && j>=0 && mat[i][j]=='.')return true;
        return false;
    }
    
	public static int numberOfCells(int n, int m, int r, int c, int U, int D, char mat[][]){
		// code here
		if(mat[r][c]=='#')return 0;
		boolean[][] collect=new boolean[n][m];
		Queue<Move> q= new ArrayDeque<>();
		int count=1;
		collect[r][c]=true;
		q.add(new Move(r,c,0,0));
		Move temp;
		int ir,jc,up,down;
		while(!q.isEmpty()){
		    temp=q.poll();
		    ir=temp.row; jc=temp.col; up=temp.up; down=temp.down;
		    //left
		    if(isSafe(mat,n,m,ir,jc-1) && !collect[ir][jc-1]){
		        collect[ir][jc-1]=true;
		        count++;
		        q.add(new Move(ir,jc-1,up,down));
		    }
		    //right
		    if(isSafe(mat,n,m,ir,jc+1) && !collect[ir][jc+1]){
		        collect[ir][jc+1]=true;
		        count++;
		        q.add(new Move(ir,jc+1,up,down));
		    }
		    //down
		    if(isSafe(mat,n,m,ir+1,jc) && !collect[ir+1][jc] && down<D){
		        collect[ir+1][jc]=true;
		        count++;
		        q.add(new Move(ir+1,jc,up,down+1));
		    }
		    //up
		    if(isSafe(mat,n,m,ir-1,jc) && !collect[ir-1][jc] && up<U){
		        collect[ir-1][jc]=true;
		        count++;
		        q.add(new Move(ir-1,jc,up+1,down));
		    }
		}
		return count;
		
	}
	
	

}


//{ Driver Code Starts.

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int u = sc.nextInt();
		    int d = sc.nextInt();
		    
		    char mat[][] = new char[n][m];

            for(int i = 0; i < n; i++)
            {
                String s = sc.next();
                for(int j = 0; j < m; j++)
                {
                    mat[i][j] = s.charAt(j);
                }
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numberOfCells(n, m, r, c, u, d, mat));
		    
		}
	}
}


// } Driver Code Ends