//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        int res[] = new int[N], k=0;
        Arrays.fill(res, Integer.MIN_VALUE);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int e:A2)hset.add(e);
        for(int e:A1)hmap.put(e,hmap.getOrDefault(e,0)+1);
        for(int e:A2){
            int occ=hmap.getOrDefault(e,-1);
            if(occ!=-1)
            for(int i=1;i<=occ;i++){
                res[k++]=e;
            }
        }
        int idx=k;
        for(int e:hmap.keySet()){
            if(!hset.contains(e)){
                int occ=hmap.get(e);
                for(int i=1;i<=occ;i++){
                    res[k++]=e;
                }
            }
        }
        Arrays.sort(res,idx,N);
        return res;
        
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		
System.out.println("~");
}
	}
	

}



// } Driver Code Ends