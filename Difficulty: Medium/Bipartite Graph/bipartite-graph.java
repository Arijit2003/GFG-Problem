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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        boolean[] visited = new boolean[V];
        HashSet<Integer> set1=new HashSet<>(), set2=new HashSet<>();
        for(int i=0;i<V;i++){
            if(!visited[i])BFS(adj,i,visited,set1,set2);
        }
        for(int e:set1){
            for(int temp:adj.get(e)){
                if(set1.contains(temp))return false;
            }
        }
        for(int e:set2){
            for(int temp:adj.get(e)){
                if(set2.contains(temp))return false;
            }
        }
        return true;
    }
    public void BFS(ArrayList<ArrayList<Integer>>adj,int src,boolean[]visited,HashSet<Integer>set1,HashSet<Integer>set2){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src]=true;
        set1.add(src);
        while(!q.isEmpty()){
            int v=q.poll();
            for(int temp: adj.get(v)){
                if(!visited[temp]){
                    visited[temp]=true;
                    q.add(temp);
                    if(set1.contains(v))set2.add(temp);
                    else if(set2.contains(v))set1.add(temp);
                }
            }
        }
    }
}