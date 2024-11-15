//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        HashSet<Integer> check = new HashSet<>();
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i)[0]).add(edges.get(i)[1]);
            adj.get(edges.get(i)[1]).add(edges.get(i)[0]);
            check.add(edges.get(i)[0]);check.add(edges.get(i)[1]);
        }
        ArrayList<Integer> vertices = new ArrayList<>();
        for(int e:check){
            vertices.add(e);
        }
        Collections.sort(vertices);
        boolean adjacent[]=new boolean[v];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        // hmap.put(0,0);
        for(int i:vertices){
            Arrays.fill(adjacent,false);
            for(int e:adj.get(i)){
                if(hmap.containsKey(e)) adjacent[hmap.get(e)]=true;
            }
            for(int j:vertices){
                if(adjacent[j]==false){
                    hmap.put(i,j);
                    // System.out.println(j);
                    break;
                }
            }
        }
        HashSet<Integer> hset = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:hmap.entrySet()){
            hset.add(entry.getValue());
        }
        return hset.size()<=m;
    }
}