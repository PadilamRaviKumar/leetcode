package optimalStrategyGamePick;



	/*T[i][j].first = max (T[i+1][j].second + val[j],
						T[i][j-1].second+ val[j])
	T[i][j].second= T[i+1][j].first or
					T[i][j-1].first*/
	
public class Solution {

	    static class Pair{
	        int first, second;
	        int pick=0;
	        public String toString(){
	            return first + " " + second + " " + pick;
	        }
	    }
	    public Pair[][] findMoves(int pots[]){
	        
	        Pair[][] moves = new Pair[pots.length][pots.length];
	        
	        for(int i=0; i < moves.length; i++){
	            for(int j=0; j < moves[i].length; j++){
	                moves[i][j] = new Pair();
	            }
	        }
	        
	        for(int i=0; i < pots.length; i++){
	            moves[i][i].first = pots[i];
	            //to track the sequence of moves
	            moves[i][i].pick = i;
	        }
	        
	        for(int l = 2; l <= pots.length; l++){
	            for(int i=0; i <= pots.length - l; i++){
	                int j = i + l -1;
	                if(pots[i] + moves[i+1][j].second > moves[i][j-1].second + pots[j]){
	                    moves[i][j].first = pots[i] + moves[i+1][j].second;
	                    moves[i][j].second = moves[i+1][j].first;
	                    moves[i][j].pick = i;
	                }else{
	                    moves[i][j].first = pots[j] + moves[i][j-1].second;
	                    moves[i][j].second = moves[i][j-1].first;
	                    moves[i][j].pick =j;
	                }
	            }
	        }
	        
	        return moves;
	    }
	    //prints the sequence of values and indexes
	    public void printSequence(int pots[], Pair moves[][]){
	        int i = 0;
	        int j = pots.length - 1;
	        int step;
	        for (int k = 0; k < pots.length; k++) {
	            step = moves[i][j].pick;
	            //this is the value of pick and its index
	            System.out.print("value: " + pots[step] + " " + "index: " + step + " ");
	            if (step <= i) {
	                i = i + 1;
	            } else {
	                j = j - 1;
	            }
	        }
	    }
}
