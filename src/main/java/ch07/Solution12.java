package ch07;



import java.util.List;

public class Solution12 {

    public static void main(String[] args) {
//        maxProfit(new int[]{7,1,5,3,6,4});
        maxProfit(new int[]{7,6,4,3,1});
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
