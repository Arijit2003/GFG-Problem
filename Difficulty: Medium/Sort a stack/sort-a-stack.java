//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    static PriorityQueue<Integer> pq;
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        pq=new PriorityQueue<>();
        sortStack(s);
        return s;
    }
    public void sortStack(Stack<Integer> st){
        if(st.isEmpty())return;
        pq.add(st.pop());
        sortStack(st);
        st.push(pq.poll());
    }
}