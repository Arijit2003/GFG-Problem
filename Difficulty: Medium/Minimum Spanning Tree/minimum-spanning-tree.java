//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int next,weight;
        Pair(int next,int w){
            this.next=next; weight=w;
        }
    }
    static class Node{
        int weight, curr,parent;
        Node(int weight, int curr, int parent){
            this.weight=weight;
            this.curr=curr;
            this.parent=parent;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> ad) {
        // Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<ad.size();i++){
            for(int j=0;j<ad.get(i).size();j++){
                int arr[]=ad.get(i).get(j);
                adj.get(i).add(new Pair(arr[0],arr[1]));
            }
        }
        // for(int i=0;i<adj.size();i++){
        //     for(Pair p:adj.get(i)){
        //         System.out.print(p.next+" "+p.weight+",");
        //     }
        //     System.out.println();
        // }
        PriorityQueue<Node> pq= new PriorityQueue<>((a,b)->{
            int val=a.weight-b.weight;
            if(val!=0)return val;
            return a.curr-b.curr;
        });
        boolean[]visited=new boolean[V];
        int sum=0;
        pq.add(new Node(0,0,-1));
        while(!pq.isEmpty()){
            Node temp=pq.poll();
            if(!visited[temp.curr]){
                visited[temp.curr]=true;
                sum+=temp.weight;
                for(Pair p:adj.get(temp.curr)){
                    if(!visited[p.next]){
                        pq.add(new Node(p.weight,p.next,temp.curr));
                    }
                }
            }
        }
        return sum;

    }
}