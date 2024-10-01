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

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int avalue, bvalue, diff;
    Pair(int avalue,int bvalue){
        this.avalue=avalue; this.bvalue=bvalue;
        this.diff=Math.abs(avalue-bvalue);
    }
    
}

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        Pair[] res=new Pair[n];
        for(int i=0;i<n;i++){
            res[i]=new Pair(arr[i],brr[i]);
        }
        Arrays.sort(res, (a,b)->a.diff-b.diff);
        long tip=0;
        for(int i=n-1;i>=0;i--){
            if(res[i].avalue>=res[i].bvalue && x>0){
                tip+=res[i].avalue; x--;
            }else if(res[i].avalue>=res[i].bvalue && x==0){
                tip+=res[i].bvalue; y--;
            }else if(res[i].bvalue>=res[i].avalue && y>0){
                tip+=res[i].bvalue; y--;
            }else if(res[i].bvalue>=res[i].avalue && y==0){
                tip+=res[i].avalue;x--;
            }
        }
        return tip;
        
    }
}
