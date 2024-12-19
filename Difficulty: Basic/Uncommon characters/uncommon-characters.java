//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        HashSet<Character> hset1 = new HashSet<>(), 
            hset2 = new HashSet<>();
        for(Character ch:A.toCharArray()){
            hset1.add(ch);
        }
        for(Character ch:B.toCharArray()){
            hset2.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:hset1){
            if(!hset2.contains(ch))sb.append(ch);
        }
        for(char ch:hset2){
            if(!hset1.contains(ch))sb.append(ch);
        }
        char[]arr=sb.toString().toCharArray();
        Arrays.sort(arr);
        
        return (sb.length()==0)?"-1":new String(arr);
    }
}