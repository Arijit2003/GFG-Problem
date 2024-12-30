//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int sum,idxA,idxB;
        Pair(int sum, int i, int j){
            this.sum=sum;
            idxA=i; idxB=j;
        }
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        quickSort(A,0,A.length-1);
        quickSort(B,0,B.length-1);
        int n=A.length;
        boolean[][]visited=new boolean[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->b.sum-a.sum);
        visited[0][0]=true;
        pq.add(new Pair(A[0]+B[0],0,0));
        ArrayList<Integer> res = new ArrayList<>();int i=0;
        while(!pq.isEmpty() && i<K){
            Pair temp = pq.poll();
            res.add(temp.sum); i++;
            //hold A
            if(temp.idxA<n && temp.idxB+1<n && !visited[temp.idxA][temp.idxB+1]){
                visited[temp.idxA][temp.idxB+1]=true;
                pq.add(new Pair(A[temp.idxA]+B[temp.idxB+1],temp.idxA,temp.idxB+1));
            }
            //hold B
            if(temp.idxA+1<n && temp.idxB<n && !visited[temp.idxA+1][temp.idxB]){
                visited[temp.idxA+1][temp.idxB]=true;
                pq.add(new Pair(A[temp.idxA+1]+B[temp.idxB],temp.idxA+1,temp.idxB));
            } 
        }
        return res;
    }
    public static void quickSort(int[]arr,int low,int high){
        if(low<=high){
            int p=lPartition(arr,low, high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    public static int lPartition(int[]arr, int low, int high){
        int pivot=arr[high];
        int i=low-1,j;
        for(j=low;j<high;j++){
            if(arr[j]>=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    public static void swap(int[]arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
