//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        
System.out.println("~");
}
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            hmap.put(inorder[i],i);
        }
        Node root=createTree(hmap,inorder,0,n-1,preorder,0,n-1);
        return root;
    }
    public static Node createTree(HashMap<Integer,Integer> hmap, int[]inorder,int inI,int inJ, int[]preorder,int preI,int preJ){
        if(inI>inJ || preI>preJ)return null;
        Node root=new Node(preorder[preI]);
        //left subtree
        int idx=hmap.get(root.data);
        int num=idx-inI;
        root.left=createTree(hmap,inorder,inI,idx-1,preorder,preI+1,preI+num);
        //right subtree
        root.right=createTree(hmap,inorder,idx+1,inJ,preorder,preI+num+1,preJ);
        return root;
    }
}
