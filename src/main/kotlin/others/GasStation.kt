package org.example.others

import kotlin.math.cos

object GasStation {
    //    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    //
    //    You have a car with an unlimited gas tank and it costs cost[i] of gas to
    //    travel from the ith station to its next (i + 1)th station. You begin the journey with
    //    an empty tank at one of the gas stations.
    //
    //    Given two integer arrays gas and cost, return the starting gas station's index
    //    if you can travel around the circuit once in the clockwise direction,
    //    otherwise return -1. If there exists a solution, it is guaranteed to be unique.

    //    Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    //    Output: 3
    //    Explanation:
    //    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4

    // Total_gas=a+b > Total_cost = c+d
    // Total_gas - total_cost = 0
    // a - c = k => b - d = -k
    //
    fun run(gas: List<Int>, cost: List<Int>): Int {
        var index = 0
        while (index != gas.size){
            var tank = 0
            var currentPos = index
            var flag = false
            while(!flag || currentPos != index){
                tank += gas[currentPos]
                if(tank >= cost[currentPos]){
                    tank -= cost[currentPos]
                    currentPos = (currentPos + 1) % gas.size
                    flag = true
                } else {
                    break
                }
            }

            if(currentPos == index && flag){
                return index
            }

            if(currentPos < index){
                return - 1
            }

            index = currentPos + 1
        }

        return -1
        TODO()
    }
}