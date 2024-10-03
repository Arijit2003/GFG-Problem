/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt(), N, count;
		for(int i=1;i<=T;i++){
		    N=sc.nextInt();
		    count=0;
		    for(int j=1;j<=N;j*=3){
		        if(1162261467%j==0)count++;
		    }
		    System.out.println(count);
		}
	}
}