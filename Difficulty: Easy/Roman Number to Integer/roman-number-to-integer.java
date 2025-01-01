//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
        HashMap<Character,Integer> hmap = new HashMap<>();
        hmap.put('I',1);hmap.put('V',5);hmap.put('X',10);
        hmap.put('L',50);hmap.put('C',100);hmap.put('D',500);
        hmap.put('M',1000);
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(hmap.get(s.charAt(i))<hmap.get(s.charAt(i+1))){
                sum+=(-1)*hmap.get(s.charAt(i));
            }else sum+=hmap.get(s.charAt(i));
        }
        sum+=hmap.get(s.charAt(s.length()-1));
        return sum;
    }
}