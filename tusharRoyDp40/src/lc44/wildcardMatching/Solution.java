package lc44.wildcardMatching;

public class Solution {

/*	T(i,j)--->check if pattern with last index i matches string with last index j
	
	T(i,j) =
	
	if P(i) == S(j) or (P(i)==? && S(j) exist){
		T(i-1,j-1)
	}
	else if(P(i)==*){
		T(i-1,j)||T(i-1,j-1)||T(i,j-1)
	}
	else false*/
	
	public boolean isMatch(String s, String p) {
		
		boolean[][] mem= new boolean[p.length()+1][s.length()+1];
		mem[0][0]=true;
		for(int r=1;r<p.length()+1;++r){
			if(p.charAt(r-1)=='*'){
				mem[r][0]=mem[r-1][0];
				}
			else 
				mem[r][0]=false;
		}
		for(int r=1;r<p.length()+1;++r){			
			for(int c=1;c<s.length()+1;++c){
				if((p.charAt(r-1)==s.charAt(c-1))||((p.charAt(r-1)=='?'&&(s.length()!=0)))){
					mem[r][c]=mem[r-1][c-1];
				}
				else if(p.charAt(r-1)=='*'){
					mem[r][c]=mem[r-1][c]||mem[r-1][c-1]||mem[r][c-1];
				}
				else
					mem[r][c]=false;
			}
		}    
	return mem[p.length()][s.length()];
	}
}
