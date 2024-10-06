//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    static boolean[] dp=new boolean[100000+1];
    static {
        getPrime(100000,dp);
    }
    Node primeList(Node head) {
        // code here
        Node temp=head;
        while(temp!=null){
            if(temp.val==1||temp.val==0){temp.val=2;temp=temp.next;continue;}
            if(dp[temp.val]){temp=temp.next;continue;}
            int leftPrime=temp.val-1;
            while(!dp[leftPrime]){leftPrime--;}
            int rightPrime=temp.val+1;
            while(!dp[rightPrime]){rightPrime++;}
            if(temp.val-leftPrime <= rightPrime-temp.val) temp.val=leftPrime;
            else temp.val=rightPrime;
            temp=temp.next;
        }
        return head;
        
    }
    
    public static void getPrime(int n,boolean []dp){
        Arrays.fill(dp,true);
        dp[0]=false; dp[1]=false;
        dp[2]=true; dp[3]=true; int j=2;
        for(int i=2;i*i<=n;i++){
            j=2;
            if(dp[i]==true)
            while(i*j<=n){
                dp[i*j]=false;
                j++;
            }
        }
    }
}