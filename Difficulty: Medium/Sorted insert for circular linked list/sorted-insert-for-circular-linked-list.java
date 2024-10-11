//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class GFG {
    static void printList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int x = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make it circular
            Solution ob = new Solution();
            Node ans = ob.sortedInsert(head, x);
            printList(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node nnode=new Node(data),last;
        Node temp=head.next,prev;
        if(temp==head){
            head.next=null;
            if(head.data<=nnode.data){
                head.next=nnode; nnode.next=head;
            }else{
                nnode.next=head; head.next=nnode;
                head=nnode;
            }
            return head;
        }
        while(head!=temp.next){
            temp=temp.next;
        }
        temp.next=null;
        last=temp;
        temp=head; prev=head;
        if(nnode.data<head.data){
            nnode.next=head;
            last.next=nnode;
            return nnode;
        }
        while(temp!=null && temp.data<=nnode.data){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null){
            prev.next=nnode;
            nnode.next=head;
        }else{
            prev.next=nnode;
            nnode.next=temp;
            last.next=head;
        }
        return head;
        
    }
}