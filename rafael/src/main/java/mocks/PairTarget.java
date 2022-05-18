package mocks;

import java.util.HashSet;
import java.util.Set;

public class PairTarget {

    public static void main(String[] args) {
        int[] arr = {3,3};
        // List, iterator, consider future changes, exceptions
        // reassign etc, prefer immutable data structure ,express explicit
        int target = 6;

        Set<Integer> set = new HashSet<>();
        boolean isFound = false;

        for(int currentElement : arr) {
            //int curr = arr[i];
            int compliment = target-currentElement; // avoid temp, make readable meaningful name
            if(set.contains(compliment)) {
                isFound = true;
                break;
            }else{
                //not present
                set.add(currentElement);
            }
        }

        System.out.println("Result: "+isFound);
    }

    private static void findPair(int[] arr, int target) {

    }
}
