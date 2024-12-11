//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String[] input = br.readLine().trim().split(" ");
            for (String s : input) {
                arr.add(Integer.parseInt(s));
            }
            int k = Integer.parseInt(br.readLine().trim());

            Solution obj = new Solution();
            boolean ans = obj.canPair(arr, k);
            System.out.println(ans ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canPair(List<Integer> arr, int k) {

        if(arr.size()%2!=0)return false;
        if(k==1)return true;
        for(int i=0;i<arr.size();i++){
            arr.set(i,arr.get(i)%k);
        }
        HashMap<Integer,Integer> hmap =new HashMap<>();
        int temp;
        for(int i=0;i<arr.size();i++){
            temp=arr.get(i);
            hmap.put(temp,hmap.getOrDefault(temp,0)+1);
        }
        HashMap<Integer,Integer> deepcopy = new HashMap<>(hmap);
        if(deepcopy.containsKey(0) && deepcopy.get(0)%2!=0)return false;
        if(deepcopy.containsKey(0) && deepcopy.get(0)%2==0) deepcopy.remove(0);
        
        for(int key:hmap.keySet()){
            if(deepcopy.containsKey(key)){
                if(!deepcopy.containsKey(k-key))return false;
                if(deepcopy.get(key)!=deepcopy.get(k-key))return false;
                deepcopy.remove(key);
                deepcopy.remove(k-key);
            }
        }
        return true;
    }
}
