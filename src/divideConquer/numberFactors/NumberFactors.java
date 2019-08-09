package divideConquer.numberFactors;
/*
Given N, count the number of ways to express N as sum of 1,3 and 4
 */
public class NumberFactors {

	public int waysToGetN(int n) {
		if ((n == 0) || (n == 1) || (n == 2)) // { }, {1}, {1,1}
			return 1; //
		if (n == 3)
			return 2; // {1,1,1}, {3}
		// step 1 : 	  		  7-1, 	 						  7-3,   			7-4
		// step 2 : 		(6-1, 6-3, 6-4),				(4-1, 4-3, 4-4), 		 2   ===  (3-1, 3-3, 3-4) == but it will return 2 line no.11
		// step 3 : (5-1, 5-3, 5-4), (4-1, 4-3, 4-4), 2 	 3, 1, 1				2
		// step 3 :  (4, 2, 1 ),      (3, 1, 0), 	 2 	     3, 1, 1				2
		// step 3 :   4, 1, 1  ,      2,  1, 1 , 	 2 	     3, 1, 1				2
		// step 4 :   (3,1,0), 1, 1  ,      2,  1, 1 , 	 2 	     3, 1, 1				2
		// step 4 :   2, 1, 1, 1, 1  ,      2,  1, 1 , 	 2 	     3, 1, 1				2

		int subtract1 = waysToGetN(n - 1); // if we subtract 1, we will be left with 'n-1'
		int subtract3 = waysToGetN(n - 3); // if we subtract 3, we will be left with 'n-3'
		int subtract4 = waysToGetN(n - 4); // if we subtract 4, we will be left with 'n-4'

		return subtract1 + subtract3 + subtract4;
	}

	
	public static void main(String[] args) {
		NumberFactors en = new NumberFactors();
		System.out.println(en.waysToGetN(4));
		System.out.println(en.waysToGetN(5));
		System.out.println(en.waysToGetN(6));
	}
	
	
}
