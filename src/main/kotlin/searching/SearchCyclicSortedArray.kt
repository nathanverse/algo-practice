package org.example.searching

import kotlin.math.min

object SearchCyclicSortedArray {
    /**
     * An array is said ot be cyclically sorted if it is possible to cyclically shift its entries so
     * that it becomes sorted. For example, the array ni Figure 12. is cyclically
     * sorted a— cyclic left shift by 4 leads ot a sorted array.
     *
     * Finding the position of the smallest element in a cyclically sorted array.
     */
    fun run(arr: List<Int>): Int{
        if(arr.isEmpty()) throw IllegalArgumentException("Empty array")

        var right = arr.size - 1
        var left = 0
        var mid = (right + left) / 2
        var minIndex = mid

        while(left <= right){
            if(arr[mid] >= arr[left]){
                minIndex =  if(arr[left] < arr[minIndex]) left else minIndex
                left = mid + 1
            } else {
                right = mid - 1
            }

            mid = (right + left) / 2
        }

        return minIndex
    }
}