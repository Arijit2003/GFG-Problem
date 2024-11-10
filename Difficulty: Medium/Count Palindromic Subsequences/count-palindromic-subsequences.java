//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long countPS(String str)
    {
        // Your code here
        int n=str.length();
        long dp[][]=new long[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return memo(dp,str,0,n-1);
    }
    long memo(long[][]dp,String str, int i, int j){
        if(i>j)return 0;
        if(i==j)return 1;
        if(dp[i][j]!=-1)return dp[i][j]%1000000007;
        if(str.charAt(i)==str.charAt(j))dp[i][j]=(memo(dp,str,i+1,j)+memo(dp,str,i,j-1)+1)%1000000007;
        else dp[i][j]=(1000000007+memo(dp,str,i+1,j)+memo(dp,str,i,j-1)-memo(dp,str,i+1,j-1))%1000000007;
        return dp[i][j]%1000000007;
    }
}