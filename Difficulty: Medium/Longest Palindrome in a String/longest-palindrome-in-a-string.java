//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        int n=S.length();
        if(n==1)return S;
        if(n==2 && S.charAt(0)==S.charAt(1))return S;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        String res="";
        for(int i=0;i<=n-2;i++){
            if(S.charAt(i)==S.charAt(i+1)){
                dp[i][i+1]=1;
                if(res.equals(""))res=S.substring(i,i+2);
            }
        }
        int maxlen=1;
        for(int len=2;len<=n;len++){
            for(int start=0;start<=n-len;start++){
                int end=start+len-1;
                if(S.charAt(start)==S.charAt(end) && dp[start+1][end-1]==1){
                    if(maxlen<(end-start+1)){
                        maxlen=end-start+1;
                        res=S.substring(start,end+1);
                    }
                    dp[start][end]=1;
                }
            }
        }
        if(res.length()==2)return res;
        if(maxlen==1)return String.valueOf(S.charAt(0));
        return res;
        
        
    }
}