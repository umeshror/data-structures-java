package greedyAlgo.coinChange;

import java.util.Arrays;
/*
Given a value V, we want to make changes for V Rupees.
 We have infinite supply of each of the denominations in Indian currency.
 i.e. we have infinite supply of {1,2,3,10, 20, 50, 100, 500, 1000} values coins/notes,
 which is the minimum number of coins and/or notes needed to make the changes for V Rs ?
 */

public class CoinChangeProblem {
    static void coinChangeProblem(int[] coins, int N) {

        Arrays.sort(coins);//Sort the coins in ascending order
        int index = coins.length - 1;
        while (true) {
            int coinValue = coins[index];
            index--;
            int maxAmount = (N / coinValue) * coinValue;
            if (maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken count: " + (N / coinValue));
                N = N - maxAmount;
            }
            if (N == 0) break;
        }
    }

}
