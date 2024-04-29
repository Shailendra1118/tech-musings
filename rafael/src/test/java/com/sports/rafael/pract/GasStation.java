package com.sports.rafael.pract;

import org.junit.jupiter.api.Test;

public class GasStation {

    @Test
    public void canCompleteCircle() {
        int[] gas = {2,3,4}; //{1,2,3,4,5};
        int[] cost = {3,4,3}; //{3,4,5,1,2};
        int startAt = 0;
        while (startAt < gas.length) {
            if (ifCirclePossible(startAt, gas, cost)) {
                System.out.println("TRUE");
                break;
            } else {
                startAt++;
            }
        }
        System.out.println("-1");
    }

    private boolean ifCirclePossible(int pos, int[] gas, int[] cost) {
        int startedAt = pos;
        int total = gas.length;
        int tank = 0;
        //start condition
        if (gas[pos] < cost[pos]) {
            return false;
        }
        while(pos < startedAt+total) {

            tank = tank + gas[pos%total];
            tank = tank - cost[pos%total];
            pos++;

            if (pos+1 == startedAt+total) {
                return true;
            }
        }
        return false;
    }
}
