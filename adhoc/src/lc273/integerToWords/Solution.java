package lc273.integerToWords;

import java.util.HashMap;
import java.util.Stack;

class Solution {
	private HashMap<Integer, String> belowHundredMap = new HashMap<Integer, String>();
	private HashMap<Integer, String> belowTwentyMap = new HashMap<Integer, String>();
	private HashMap<Integer, String> denomsMap = new HashMap<Integer, String>();
	private final String[] belowTwenty = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private final String[] belowHundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };
	private final String[] denoms=new String[] { "","Thousand","Million","Billion"};

	Solution() {
		int i=0;
		for(int j=0;j<belowTwenty.length;++j){
			belowTwentyMap.put(i++, belowTwenty[j]);
		}
		i=0;
		for(int j=0;j<belowHundred.length;++j){
			belowHundredMap.put(i++, belowHundred[j]);
		}
		i=0;
		for(int k=0;k<denoms.length;++k){
			denomsMap.put(i++, denoms[k]);
		}
	}
	
	  public String numberToWords(int num) {
		  if (num==0) return "Zero";
		  String finalword="";
		  
		  Stack<Integer> st=new Stack<Integer>();
		while(num>0){
			int count=0;
			int x=0;
			int tmp=0;
			int i=0;
			while(count!=3 && num>0){
				x=num%10;
				 tmp=(int) (tmp+(x*Math.pow(10, i)));
				
				count++;
				i++;
				num=num/10;
			}
			if(tmp!=0)
			st.push(tmp);
			else
				st.push(-1);
		}
		while(!st.isEmpty()){
			int dig=st.peek();
			if(dig==-1) {
				st.pop();
				continue;
			}
	        String denom=denomsMap.get(st.size()-1);
	        String word=getWords(st.pop());
	        finalword=finalword+word+" "+denom+" ";
		}
		return finalword.trim();
	    }

	private String getWords(int num) {

		String word = auxGetWords(num);
		//System.out.println(word);
		return word;
	}

	private String auxGetWords(int num) {
		String word="";
		String snum=num+"";
		
		String slastTwo="";
		switch(snum.length()){
		case 1:
			slastTwo=snum;
			break;
		case 2:
			slastTwo=snum;
			break;
		default:
			slastTwo=snum.substring(1);
			break;
		}
		
		int lastTwo=Integer.parseInt(slastTwo);
		String s1;
		if(lastTwo<20){
		s1=belowTwentyMap.get(lastTwo);
		}
		else{
			s1=(belowHundredMap.get(lastTwo/10)+" "+belowTwentyMap.get(lastTwo%10)).trim();
		 
		}
		String s2="";
		if(snum.length()>=3){
		String sthird=snum.substring(0,1);
		int third=Integer.parseInt(sthird);
			s2=belowTwentyMap.get(third);
		if(s2.length()>0){
			s2=s2+" "+"Hundred";
		}
		}
		word=s2+" "+s1;
		return word.trim();
	}	
}