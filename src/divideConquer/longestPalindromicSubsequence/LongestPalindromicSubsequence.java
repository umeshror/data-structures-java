package divideConquer.longestPalindromicSubsequence;
/*
* We are given a string ’S’
* We need to find the length of its Longest Palindromic Subsequence in the given ’S’ String
* A subsequence is a sequence that can be derived from another string by deleting some or no elements without changing the order of the remaining elements
* Palindrome is astinrg that reads the same backward as well as forward and can be of odd or even length

e.g. 1
Input: ‘ELRMENMET’
Output: 5
LPS is EMEME

 */

class LongestPalindromicSubsequence {

	public int findLPSLength(String st) {
		return LPSAux(st, 0, st.length() - 1);
	}


	private int LPSAux(String st, int startIndex, int endIndex) {
		if (startIndex > endIndex) { //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
			return 0;
		}
		if (startIndex == endIndex) { //BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
			return 1;
		}
		int count1 = 0;
		if (st.charAt(startIndex) == st.charAt(endIndex)) { //CASE#1 - If index pointed characters matches then we add 2 to the existing known palindrome length
			count1 = 2 + LPSAux(st, startIndex + 1, endIndex - 1);
		}
		int Count2 = LPSAux(st, startIndex + 1, endIndex); //CASE#2 - Skip one element from beginning
		int Count3 = LPSAux(st, startIndex, endIndex - 1); //CASE#3 - Skip one element from end
		return Math.max(count1,Math.max(Count2, Count3));
	}


	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println("Longest Palindromic Sequence: " + lps.findLPSLength("elrmenmet"));
	}
}