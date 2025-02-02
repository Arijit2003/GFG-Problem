//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    public static int getMaxArea(int arr[]) {
        // your code here
        int n=arr.length;
        int prev[]=new int[n], next[]=new int[n];
        prevGreaterElement(arr,prev);
        nextSmallerElement(arr,next);
        // System.out.println(Arrays.toString(prev));
        // System.out.println(Arrays.toString(next));
        int max=Integer.MIN_VALUE,val;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]*(next[i]-prev[i]-1));
        }
        return max;
    }
    public static void prevGreaterElement(int[]arr,int []prev){
        Stack<Integer> st = new Stack<>();
        prev[0]=-1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[st.peek()]) prev[i]=st.peek();
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
                if(st.isEmpty()) prev[i]=-1;
                else prev[i]=st.peek();
            }
            st.push(i);
        }
    }
    public static void nextSmallerElement(int[]arr,int[]next){
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        next[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[st.peek()]) next[i]=st.peek();
            else{
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
                if(st.isEmpty())next[i]=n;
                else next[i]=st.peek();
            }
            st.push(i);
        }
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends