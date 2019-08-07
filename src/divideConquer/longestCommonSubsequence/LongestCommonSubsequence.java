package divideConquer.longestCommonSubsequence;
/*
* We are given 2 strings
* We need to find the length of the longest subsequence which is common in both the strings
* Subsequence is a sequence that can be derived from another sequence buy deleting some elements without changing the order of the remaining elements

e.g.  ABCDE is sequence
Sol: ADE, ACE, ACD, ABD, ABCE and ABDE are sequences
e.g.
S1: elephant
S2 eretpat

Output :5, The longest substring is “expat"
 */


public class LongestCommonSubsequence {

	public int findLCSLength(String s1, String s2) {
		return findLCSLengthAux(s1, s2, 0, 0);
	}

	
	private int findLCSLengthAux(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length())//Base Case
			return 0;
		
		int c3 = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {//If current character in both the string matches, then increase the index by 1 in both the strings.
			c3 = 1 + findLCSLengthAux(s1, s2, i1 + 1, i2 + 1);
		}

		int c1 = findLCSLengthAux(s1, s2, i1, i2 + 1);//Increase index of 2nd String
		int c2 = findLCSLengthAux(s1, s2, i1 + 1, i2);//Increase index of 1st String
		
		return Math.max(c3, Math.max(c1, c2));
	}

	
	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.findLCSLength("houdini", "hdupti"));
	}
	
}