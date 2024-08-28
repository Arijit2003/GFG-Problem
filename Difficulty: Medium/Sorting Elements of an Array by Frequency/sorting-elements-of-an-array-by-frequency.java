//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    static class Pair{
        int ele,occ;
        Pair(int element,int occurrence){
            ele=element;
            occ=occurrence;
        }
    }
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer,Integer>hmap=new HashMap<>();
        for(int e:arr){
            hmap.put(e,1+hmap.getOrDefault(e,0));
        }
        ArrayList<Pair>arrLst= new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry: hmap.entrySet()){
            arrLst.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(arrLst,(a,b)->{
            if(a.occ==b.occ)return a.ele-b.ele;
            return b.occ-a.occ;
        });
        ArrayList<Integer> res= new ArrayList<>();
        for(Pair p:arrLst){
            for(int i=1;i<=p.occ;i++){
                res.add(p.ele);
            }
        }
        return res;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends