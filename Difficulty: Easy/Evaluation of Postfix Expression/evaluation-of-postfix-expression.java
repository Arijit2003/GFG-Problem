//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s) {
        // Your code here
        Stack<Integer> st=new Stack<>();
        for(char ele:s.toCharArray()){
            if(ele=='*' || ele=='/' || ele=='+' || ele=='-'){
                int op1=st.pop();
                int op2=st.pop();
                switch(ele){
                    case '+':{
                        st.push(op1+op2);
                        break;
                    }
                    case '-':{
                        st.push(op2-op1);
                        break;
                    }
                    case '*':{
                        st.push(op1*op2);
                        break;
                    }case '/':{
                        st.push(op2/op1);
                        break;
                    }
                }
            }else st.push(ele-48);
        }
        return st.pop();
    }
}