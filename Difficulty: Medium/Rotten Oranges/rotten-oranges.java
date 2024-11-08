//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find minimum time required to rot all oranges.
    class Pair{
        int row,col,time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int rows=mat.length,cols=mat[0].length,ctOne=0;
        int rotten[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==2){
                    rotten[i][j]=2;
                    q.add(new Pair(i,j,0));
                }else if(mat[i][j]==1)ctOne++;
            }
        }
        if(q.isEmpty() && (ctOne==rows*cols)) return -1;
        int maxtime=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            maxtime=Math.max(maxtime,p.time);
            
            //up
            if(isFresh(rows,cols,p.row-1,p.col,mat)){
                rotten[p.row-1][p.col]=2;
                mat[p.row-1][p.col]=2;
                q.add(new Pair(p.row-1,p.col,p.time+1));
            }
            //down
            if(isFresh(rows,cols,p.row+1,p.col,mat)){
                rotten[p.row+1][p.col]=2;
                mat[p.row+1][p.col]=2;
                q.add(new Pair(p.row+1,p.col,p.time+1));
            }
            //left
            if(isFresh(rows,cols,p.row,p.col-1,mat)){
                rotten[p.row][p.col-1]=2;
                mat[p.row][p.col-1]=2;
                q.add(new Pair(p.row,p.col-1,p.time+1));
            }
            //right
            if(isFresh(rows,cols,p.row,p.col+1,mat)){
                rotten[p.row][p.col+1]=2;
                mat[p.row][p.col+1]=2;
                q.add(new Pair(p.row,p.col+1,p.time+1));
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1 )return -1;
            }
        }
        return maxtime;
        
    }
    public boolean isFresh(int rows,int cols,int r,int c,int[][]mat){
        if(r<0 || r>=rows || c<0 || c>=cols || mat[r][c]==2|| mat[r][c]==0) return false;
        return true;
    }
}