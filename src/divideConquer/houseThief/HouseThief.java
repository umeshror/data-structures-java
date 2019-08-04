package divideConquer.HouseThief;
/*
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses
 * But he can’t steal in two adjacent houses
 * What is the maximum stolen value ?
 *
 */

public class HouseThief {

    public int maxMoney(int[] HouseNetWorth) {
        return maxMoneyRecursive(HouseNetWorth, 0);
    }//end of method

    private int maxMoneyRecursive(int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length)
            return 0;

        int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(HouseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex + 1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(ht.maxMoney(HouseNetWorth));
        /*
        Input = {6, 7, 1,30 ,8 , 2, 4}
        Output 41
        Thief will steal : House # 7, 30, 4
         */
        HouseNetWorth = new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxMoney(HouseNetWorth));


    }
}
