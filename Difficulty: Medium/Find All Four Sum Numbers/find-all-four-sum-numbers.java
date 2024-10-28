//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            // String[] nk = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(nk[0]);
            // int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.println();
            }
            if (ans.isEmpty()) {
                System.out.println(-1);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        
        int n=arr.length;
        if(n<4)return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);
        for(int i=0;i<=n-4;i++){
            for(int j=i+1;j<=n-3;j++){
                int s=j+1,e=n-1;
                int target=k-(arr[i]+arr[j]);
                while(s<e){
                    int sum=arr[s]+arr[e];
                    if(sum<target)s++;
                    else if(sum>target)e--;
                    else{
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]); temp.add(arr[j]);
                        temp.add(arr[s]); temp.add(arr[e]);
                        if(!res.contains(temp))res.add(temp);
                        s++;e--;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> actr = new ArrayList<>(res);
        actr.sort((a,b)->{
            for(int i=0;i<a.size();i++){
                int compare = Integer.compare(a.get(i),b.get(i));
                if(compare!=0)return compare;
            }
            return 0;
        });
        return  actr;
    }
}