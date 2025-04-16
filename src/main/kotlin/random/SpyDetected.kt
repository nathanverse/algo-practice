package org.example.random

import java.io.BufferedReader
import java.io.InputStreamReader


fun getDistinctIndex(nums: List<Int>): Int{
    if(nums.size < 3){
        throw IllegalArgumentException()
    }

    var (firstCount, secondCount) = 0 to 0
    var secondIndex = -1
    for (i in 0..2){
        if(nums[i] != nums[0]){
            secondCount += 1
            secondIndex = i
        } else {
            firstCount += 1
        }
    }

    if(secondIndex != -1){
        return if(firstCount > 1) 1 else secondIndex + 1
    }

    for(i in 3..<nums.size){
        if (nums[i] != nums[0]){
            return i+1
        }
    }

    throw IllegalArgumentException()
}

/**
 * Link: https://codeforces.com/problemset/problem/1512/A
 */
fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    repeat(n){
        val size = reader.readLine().toInt()
        val intList = reader.readLine().split(" ").map { it.toInt() }
        println(getDistinctIndex(intList))
    }
}