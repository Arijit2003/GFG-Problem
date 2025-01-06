//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.findElement(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findElement(List<Integer> arr) {
        // Code here
        int n=arr.size();
        int[]left=new int[n];
        int[]right=new int[n];
        left[0]=arr.get(0);
        int lar=left[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(arr.get(i),lar);
            lar=left[i];
        }
        right[n-1]=arr.get(n-1);
        int sml=right[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.min(arr.get(i),sml);
            sml=right[i];
        }
        for(int i=1;i<=n-2;i++){
            if(left[i-1]<arr.get(i) && arr.get(i)<right[i+1]) return arr.get(i);
        }
        return -1;
    }
}