//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    class Pair{
        int element,idx;
        Pair(int e, int i){
            element=e; idx=i;
        }
    }
    public int minSwaps(int nums[]){
        // Code here
        int n=nums.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(nums[i],i);
        }
        Arrays.sort(arr,(a,b)->a.element-b.element);
        int count=0,i=0,j;
        while(i<n){
            j=arr[i].idx;
            if(i==j)i++;
            else{
                Pair temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                count++;
            }
        }
        return count;
        
        
    }
    
}