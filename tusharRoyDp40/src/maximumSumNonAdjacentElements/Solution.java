package maximumSumNonAdjacentElements;

/*T(j)=max{T(j-2)+ar[j],T(j-1)}*/
public class Solution {
	public int maximumSumNonAdjacent(int[] ar) {		
		int mem[] = new int[ar.length + 2];
		for (int i = 2; i < mem.length; ++i) 
			mem[i] = Math.max(mem[i - 2] + ar[i-2], mem[i - 1]);
		
		return mem[mem.length - 1];
	}
}
