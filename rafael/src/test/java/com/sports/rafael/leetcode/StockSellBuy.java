package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StockSellBuy {

    @Test
    public void testMultipleStocks() {
        int[] prices = {7,1,5,3,6,4};
        int[] res = trade(prices.length-1, prices); //start from last day Top-2-Bottom approach
        System.out.println("RES: "+ Arrays.toString(res));
    }

    private int[] trade(int day, int[] prices) {
        //base case
        if (day == 0) {
            //1st day, I can buy or sell
            return new int[] {-prices[day], 0}; // same day buy & sell gives 0 profit for that day
        }
        //recurse
        int[] prev = trade(day-1, prices);
        //start stacking up
        int sell = Math.max(prev[0], prev[1]-prices[day]); //choose max, if first is kept, we hold and did not sell | And we bought so price is subtracted
                                    //---we bought----
        int buy = Math.max(prev[1], prev[0]+prices[day]); //chose max, if first is kept, we hold and did not buy, otherwise we sold
                                    //---we sold----
        return new int[]{sell, buy};
    }
}
