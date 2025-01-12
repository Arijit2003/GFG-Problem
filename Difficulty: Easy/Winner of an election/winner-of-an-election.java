//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        
System.out.println("~");
}
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> hmap=new HashMap<>();
        for(String str:arr)hmap.put(str,hmap.getOrDefault(str,0)+1);
        String res=""; int count=0;
        for(Map.Entry<String,Integer>entry:hmap.entrySet()){
             if(entry.getValue()>count){
                res=entry.getKey();
                count=entry.getValue();
             }else if(entry.getValue()==count){
                 res=res.compareTo(entry.getKey())<=0?res:entry.getKey();
             }
        }
        return new String[]{res,String.valueOf(count)};
    }
}

