//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {

    /* Function to print linked list */
    public static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node result = ob.compute(head);
            print(result);
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution {
    Node compute(Node head) {
        // your code here
        head=reverse(head);
        Node prev=null,curr=head;
        int prevmax=Integer.MIN_VALUE;
        while(curr!=null){
            if(curr.data<prevmax){
                prev.next=curr.next;
                curr=curr.next;
            }else{
                prevmax=Math.max(prevmax,curr.data);
                prev=curr;
                curr=curr.next;
            }
        }
        head=reverse(head);
        return head;
    }
    Node reverse(Node head){
        if(head==null)return head;
        Node prev=null,curr=head,next=head.next,temp;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next==null) break;
            next=next.next;
        }
        return prev;
    }
    // public void traverse(Node head){
    //     while(head!=null){
    //         System.out.print(head.data+" ");
    //         head=head.next;
    //     }
    //     System.out.println();
    // }
}
