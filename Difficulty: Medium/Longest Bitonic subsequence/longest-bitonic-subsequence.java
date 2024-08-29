//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] arr) {
        // code here
        int lis[]=new int[n], lds[]=new int[n];
        //lis
        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]) lis[i]=Math.max(lis[i],1+lis[j]);
            }
        }
        //lds
        lds[n-1]=1;
        for(int i=n-2;i>=0;i--){
            lds[i]=1;
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j])lds[i]=Math.max(lds[i],1+lds[j]);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(lis[i]==1||lds[i]==1)continue;
            max=Math.max(max,lis[i]+lds[i]-1);
        }
        return max;
    }
    
}
