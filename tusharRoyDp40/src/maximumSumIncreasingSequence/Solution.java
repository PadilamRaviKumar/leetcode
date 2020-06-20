package maximumSumIncreasingSequence;

public class Solution {

	int gmax=Integer.MIN_VALUE;
	public int maximumSumIncreasingSubsequence(int[] ar){
		if (ar.length==0) return gmax;
		int mem[]=new int[ar.length];
		mem[0]=ar[0];
		for(int i=1;i<mem.length;++i){
			int lmax=Integer.MIN_VALUE;
			for(int j=0;j<i;++j){
				if(ar[j]<ar[i]){
					lmax=Math.max(mem[j], lmax);
				}
			}
			mem[i]=Math.max(ar[i], lmax+ar[i]);
			gmax=Math.max(mem[i], gmax);
		}
		return gmax;
	}
	
}
