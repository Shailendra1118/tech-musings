package com.sports.rafael.karat;

/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]

Complexity analysis variables:

n: number of logs in the input
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class KaratRoo {

    public static void main(String[] args) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };


        // String[][] res = getAccessTime(logs1);
        // System.out.println(Arrays.deepToString(res));

        // String[][] res1 = getAccessTime(logs2);
        // System.out.println(Arrays.deepToString(res1));

        // String[][] res2 = getAccessTime(logs3);
        // System.out.println(Arrays.deepToString(res2));

        String[] resource = getAccessTime(logs1);
        System.out.println(Arrays.toString(resource));

        String[] resource1 = getAccessTime(logs2);
        System.out.println(Arrays.toString(resource1));

        String[] resource2 = getAccessTime(logs3);
        System.out.println(Arrays.toString(resource2));
    }

    private static String[] getAccessTime(String[][] logs1) {
        int accessCountIn5 = 0;
        Map<String, TreeSet<Integer>> accessMap = new HashMap<>();
        for(int i=0; i<logs1.length; i++) {
            String[] log = logs1[i];
            String resource = log[2];
            if(accessMap.containsKey(resource)) {
                accessMap.get(resource).add(Integer.valueOf(log[0]));
            }else{
                TreeSet<Integer> time = new TreeSet<>();
                time.add(Integer.valueOf(log[0]));
                accessMap.put(resource, time);
            }
        }


        String maxResource = "";
        String[][] result = new String[accessMap.entrySet().size()][logs1[0].length];
        int maxCount = 0;
        for(Map.Entry<String, TreeSet<Integer>> entry : accessMap.entrySet()){
            //System.out.println(entry.getKey()+":"+entry.getValue());
            String currResource = entry.getKey();
            int currCount = getAccessCountWith5(currResource, new ArrayList<>(entry.getValue()));
            //System.out.println(currResource+":"+currCount);
            if(currCount > maxCount) {
                maxCount = currCount;
                maxResource = entry.getKey();
            }
            //List<String> res = new ArrayList<>();
            //res.add(entry.getKey());
            //res.add(String.valueOf(entry.getValue().first()));
            //res.add(String.valueOf(entry.getValue().last()));
            //result[count++] = res.toArray(new String[0]);
            //System.out.println(Arrays.toString(res.toArray()));

        }
        return new String[]{maxResource, String.valueOf(maxCount)};

    }

    private static int getAccessCountWith5(String resource, List<Integer> times) {
        List<Integer> result = new ArrayList<>();
        Integer[] accessTimes = times.toArray(new Integer[0]);
        int maxCount = 0;
        for(int i=0; i<accessTimes.length; i++) {
            //int startIdx = i;
            int j = i+1;
            int count = 1;
            int maxRange = accessTimes[i]+300;
            while(j<accessTimes.length) {
                if(accessTimes[j] <= maxRange) {
                    count++;
                    j++;
                }else {
                    break;
                }
            }
            //check maxCount
            if(count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

}
