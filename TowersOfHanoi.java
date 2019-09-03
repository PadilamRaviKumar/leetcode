package com.algo.noteproblems;

public class TowersOfHanoi {
	
	char src='A',aux='B',tar='C';

	
	void hanoi(int n,char src,char tar,char aux){
		
		if(n==1){
			System.out.println(src+"--->"+tar);
		return;
		}
		else
		{
			hanoi(n-1, src, aux, tar);
			System.out.println(src+"--->"+tar);
			hanoi(n-1, aux, tar, src);
			return;
		}
		
	}
	
	public static void main(String[] args) {
		
		new TowersOfHanoi().hanoi(3, 'A', 'C', 'B');
	}
	
	
}
