package mocks;

public class TrappedRain {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        int water = getTotalTrappedWater(heights);
        System.out.println("Res: "+water);
    }

    private static int getTotalTrappedWater(int[] heights) {
        int maxLeft[] = findMaxOnLeft(heights); //{0,1,1,2,2,2,2,3,3,3,3,3};
        int maxRight[] = findMaxOnRight(heights); //{3,3,3,3,3,3,3,3,2,2,2,1};
        int totalWater = 0;
        for(int i=0; i<heights.length; i++){

            int min = Math.min(maxLeft[i], maxRight[i]);
            totalWater += min - heights[i];

        }
        return totalWater;
    }

    private static int[] findMaxOnRight(int[] heights) {
        int right[] = new int[heights.length];
        int maxTillNow = heights[heights.length-1];
        right[right.length-1] = maxTillNow;
        for(int i=heights.length-2; i>=0; i--){
            if(heights[i] > maxTillNow) {
                maxTillNow = heights[i];
            }
            right[i] = maxTillNow;
        }
        return right;
    }

    private static int[] findMaxOnLeft(int[] heights) {
        int left[] = new int[heights.length];
        int maxTillNow = heights[0];
        left[0] = maxTillNow;
        for(int i=1; i<heights.length; i++){
            if(heights[i] > maxTillNow) {
                maxTillNow = heights[i];
            }
            left[i] = maxTillNow;
        }
        return left;
    }
}
