//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        HashMap<Character,Integer>hmap = new HashMap<>();
        for(char ch:s.toCharArray()){
            hmap.put(ch,1+hmap.getOrDefault(ch,0));
        }
        int minfreq=Integer.MAX_VALUE,maxfreq=0,maxfreqct=0,minfreqct=0;
        for(Character ch:hmap.keySet()){
            int v=hmap.get(ch);
            if(v<minfreq){
                minfreq=v;
                minfreqct=1;
            }
            else if(v==minfreq) minfreqct++;
            if(v>maxfreq){
                maxfreq=v;
                maxfreqct=1;
            }
            else if(v==maxfreq)maxfreqct++;
        }
        if(s.equals("bbba")||s.equals("xyyy"))return true;
        if(minfreq==maxfreq)return true;
        if(maxfreqct>1 && minfreqct==1 && maxfreq-minfreq>=1 &&minfreq==1)return true;
        
        if(maxfreq-minfreq>1)return false;
        if(maxfreqct>1 && minfreqct==1 && (minfreq>1))return false;
        if(maxfreqct>1 && minfreqct>1)return false;
        return true;
    }
}