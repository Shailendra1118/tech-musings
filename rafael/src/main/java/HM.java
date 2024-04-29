import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HM {

    public static void main(String[] args) {
//        int[] days = {1,3,5,6,7};
//        Set<Integer> set = new HashSet<>();
//        Arrays.stream(days).forEach(n -> set.add(n));
//        System.out.println(set.contains(1));
//        Arrays.fill(days, -1);
//        System.out.println(Arrays.toString(days));

        int[] days = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        Set<Integer> travels = new HashSet<>();
        Arrays.stream(days).forEach(n -> travels.add(n));
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        Arrays.fill(dp, -1);
        int res = findMinCost(days, costs, travels, 1, dp);
        System.out.println("Res: "+ res);


    }

    private static int findMinCost(int[] days, int[] costs, Set<Integer> travels, int currDay, int[] dp) {
        //base case
        if(currDay > days[days.length-1]) {
            return 0;
        }
        if(dp[currDay] != -1) {
            return dp[currDay];
        }
        if(travels.contains(currDay)) {
            //travel required on this day
            int minCost = Math.min(costs[0]+findMinCost(days, costs, travels, currDay+1, dp),
                    Math.min(costs[1]+findMinCost(days, costs, travels, currDay+7, dp),
                            costs[2]+findMinCost(days, costs, travels, currDay+30, dp)));
            return dp[currDay] = minCost;
        }else{
            return findMinCost(days, costs, travels, currDay+1, dp);
        }
    }
}
