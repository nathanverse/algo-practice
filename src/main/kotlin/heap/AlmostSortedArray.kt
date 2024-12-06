package org.example.heap

import java.util.PriorityQueue
import kotlin.math.min

/**
 *
 * Often data is almost-sorted—for example, a server receives timestamped stock quotes and earlier quotes may arrive slightly after later quotes
 * because of differences in server loads and network routes. In this problem we address efficient ways to sort such data. Write a program which takes
 * as input a very long sequence of numbers and prints the numbers in sorted order. Each number is at most k away from its correctly sorted position.
 * (Such an array is sometimes referred to as being k-sorted). For example, no number in the sequence {3,-1,2,6,4,5,8} is more than 2 away from its final sorted position.
 *
 */
object AlmostSortedArray {
    data class Node(
        val value: Int,
        val index: Int
    )


    fun run(
        elements: List<Int>,
        k: Int
    ): String {
        if(elements.isEmpty()){
            throw IllegalArgumentException("Not thing to export")
        }

        val minHeap = PriorityQueue<Node>(compareBy({ it.value }))

        // Put k elements in to heap
        var temp = 0
        var result = ""
        while(temp < elements.size && temp < k){
            minHeap.add(Node(value = elements[temp], index = temp))
            temp += 1
        }

        // As k is added we compare and pop out the last element
        temp = k
        while(temp < elements.size){
            minHeap.add(Node(value = elements[temp], index = temp))
            if(minHeap.peek().index + k < temp){
                val minNode = minHeap.poll()
                result += "${minNode.value},"
            }

            temp += 1
        }

        // Print last k element
        while (minHeap.isNotEmpty()){
            result += "${minHeap.poll().value},"
        }

        return result.slice(0 ..< result.length - 1)
    }
}