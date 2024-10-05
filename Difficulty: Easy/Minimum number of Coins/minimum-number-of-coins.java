//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        int n2000=0,n500=0,n200=0,n100=0,n50=0,n20=0,n10=0,n5=0,n2=0,n1=0;
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(N>=2000){
            n2000=N/2000;
            for(int i=1;i<=n2000;i++) res.add(2000);
            N=N%2000;
        }
        if(N>=500){
            n500=N/500;
            for(int i=1;i<=n500;i++) res.add(500);
            N=N%500;
        }
        if(N>=200){
            n200=N/200;
            for(int i=1;i<=n200;i++) res.add(200);
            N=N%200;
        }
        if(N>=100){
            n100=N/100;
            for(int i=1;i<=n100;i++)res.add(100);
            N=N%100;
        }
        if(N>=50){
            n50=N/50;
            for(int i=1;i<=n50;i++) res.add(50);
            N=N%50;
        }
        if(N>=20){
            n20=N/20;
            for(int i=1;i<=n20;i++) res.add(20);
            N=N%20;
        }if(N>=10){
            n10=N/10;
            for(int i=1;i<=n10;i++) res.add(10);
            N=N%10;
        }if(N>=5){
            n5=N/5;
            for(int i=1;i<=n5;i++) res.add(5);
            N=N%5;
        }
        if(N>=2){
            n2=N/2;
            for(int i=1;i<=n2;i++) res.add(2);
            N=N%2;
        }
        if(N>=1){
            n1=N/1;
            for(int i=1;i<=n1;i++) res.add(1);
            N=N%2000;
        }
        return res;
        
    }
}