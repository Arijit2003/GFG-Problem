//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int[] b = new int[nk.length];
            for (int i = 0; i < nk.length; i++) {
                b[i] = Integer.parseInt(nk[i]);
            }
            Solution sln = new Solution();
            boolean ans = sln.findSwapValues(a, b);
            if (ans) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            // System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
        HashSet<Integer> hset = new HashSet<>();
        int sum1=0,sum2=0;
        for(int e:a) sum1+=e;
        for(int e:b) sum2+=e;
        int diff=Math.abs(sum1-sum2),
        dist=diff/2,
        min=Math.min(sum1,sum2),max=Math.max(sum1,sum2),ele=0;
        if(diff==0)return true;
        if(diff%2!=0)return false;
        for(int e:a){
            hset.add(e);
        }
        for(int e:b){
            if(sum2<sum1){
                if(hset.contains(e+dist)){
                    if(max-dist== min+dist) return true;
                }
            }else if(sum2>sum1){
                if(hset.contains(e-dist)){
                    if(max-dist== min+dist) return true;
                }
            }
        }
        return false;
        
    }
}
