package dynamicProgramming.numberFactors;

/*
Given N, count the number of ways to express N as sum of 1,3 and 4
E.g.N =  4
Number of ways = 4
Sol: {4}, {1,3}, {3,1}, {1,1,1,1}
*/
public class NumberFactorsBottomUp {

    public int waysToGetN(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1; // BaseCases
        dp[3] = 2; // BaseCases

        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

        return dp[n];
    }


    public static void main(String[] args) {
        NumberFactorsBottomUp en = new NumberFactorsBottomUp();
        System.out.println(en.waysToGetN(4));
        System.out.println(en.waysToGetN(5));
        System.out.println(en.waysToGetN(6));
    }


}