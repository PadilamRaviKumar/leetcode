package lc97.stringInterleaving;

import java.util.HashMap;

class Solution {
    HashMap<String,Boolean> mem=new HashMap<String,Boolean>();
	boolean l=true,r=true;
	public boolean isInterleave(String s1, String s2, String s3) {
       if((s1.length()+s2.length())!=s3.length()) return false;
		boolean[][] mem=new boolean[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<=s1.length();++i) {
			mem[i][0]=(s1.substring(0, i)).equals(s3.substring(0, i));
		}
		for(int i=0;i<=s2.length();++i) {
			mem[0][i]=(s2.substring(0, i)).equals(s3.substring(0, i));
		}
		for(int i=1;i<=s1.length();++i) {
			for(int j=1;j<=s2.length();++j) {
				if((s1.charAt(i-1)==s3.charAt(i+j-1))&&(s2.charAt(j-1)==s3.charAt(i+j-1))) {
					mem[i][j]=mem[i-1][j]||mem[i][j-1];
				}
				else if(s1.charAt(i-1)==s3.charAt(i+j-1)) mem[i][j]=mem[i-1][j];
				else if(s2.charAt(j-1)==s3.charAt(i+j-1)) mem[i][j]=mem[i][j-1];
				
				else mem[i][j]=false;
			}
		}
		return mem[s1.length()][s2.length()];
	}

}
