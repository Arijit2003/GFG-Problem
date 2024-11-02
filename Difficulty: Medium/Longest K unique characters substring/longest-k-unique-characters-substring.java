//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hmap = new HashMap<>();
        int max=0,count=0,i=0,j=0,n=s.length();
        while(j<n){
            hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
            count++;
            if(hmap.size()<=k){
                max=Math.max(max,count);
                j++;
            }
            else{
                while(hmap.size()>k && i<j){
                    char c=s.charAt(i++);
                    hmap.put(c,hmap.get(c)-1);
                    if(hmap.get(c)<=0)hmap.remove(c);
                    count--;
                }
                max=Math.max(max,count);
                j++;
            }
        }
        // System.out.println(i+":"+j);
        if(hmap.size()<k)return -1;
        return max;
    }
}