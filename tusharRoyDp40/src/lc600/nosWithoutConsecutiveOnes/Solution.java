package lc600.nosWithoutConsecutiveOnes;

/*this is a fibonacci series
1-2
2--3
3--5
4--8
5--13*/
public class Solution {
int count=0;
	 public int findIntegers(int num) {
         
		 for(int i=0;i<=num;++i){
			 boolean flag=checkConsecutive(i);
			 if(flag==true) count++;
		 }
		 return count;
	    }
	private boolean checkConsecutive(int i) {
		if(i==1) return true;
		int prev=-1,current = 0,xorval;
		int mask=1;
		int tmp=i;
		for(int j=1;j<32;++j){
			current=tmp&mask;
			if(prev==-1) prev =current^1;
			xorval=prev^current;
			if(xorval==0 && current==1) return false;
			else{
				prev=current;
				tmp=i>>>j;
			}
		}
		return true;
	}
}
