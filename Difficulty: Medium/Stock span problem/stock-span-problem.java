//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            // System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    class Pair{
        int element,idx;
        Pair(int e, int i){
            element=e;
            idx=i;
        }
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(arr[0],0));
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<st.peek().element){
                res.add(1);
                
            }else{
                while(!st.isEmpty() && arr[i]>=st.peek().element){
                    st.pop();
                }
                if(st.isEmpty())res.add(i+1);
                else res.add(i-st.peek().idx);
                
            }
            st.add(new Pair(arr[i],i));
        }
        return res;
    }
}