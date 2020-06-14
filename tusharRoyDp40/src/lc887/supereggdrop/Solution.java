package lc887.supereggdrop;

public class Solution {

	/*T(N,K)=Math.min{x->1..N{Math.max{T(X-1,K-1),T(N-X,K)}*/
	
	 public int superEggDrop(int K, int N) {
	        int[][] memo = new int[K + 1][N + 1];
	        return helper(K, N, memo);
	    }
	    private int helper(int K, int N, int[][] memo) {
	        if (N <= 1) {
	            return N;
	        }
	        if (K == 1) {
	            return N;
	        }
	        if (memo[K][N] > 0) {
	            return memo[K][N];
	        }
	        
	        int low = 1, high = N, result = N;
	        while (low < high) {
	            int mid = low + (high - low) / 2;
	            int left = helper(K - 1, mid - 1, memo);
	            int right = helper(K, N - mid, memo);
	            result = Math.min(result, Math.max(left, right) + 1);
	            if (left == right) {
	                break;
	            } else if (left < right) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        memo[K][N] = result;
	        return result;
	    }
			
}
