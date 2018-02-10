package oj134GasStation;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.

 * Created by xueyingbai on 2/9/18.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int gas_sum = 0;
        int cost_sum = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++) {
            gas_sum += gas[i];
            cost_sum += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if(gas_sum < cost_sum) {
            return -1;
        }
        return start;
    }
}
