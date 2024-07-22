package org.example.hash_table_13

object FindKthLargestElement {
    fun run(array: Array<Int>){
        val pivot = array[0]
        var i = 1
        var firstIndexLargest = 1
        while(i < array.size){
            if(array[i] < pivot){
                val smallElement = array[i]
                array[i] = array[firstIndexLargest]
                array[firstIndexLargest] = smallElement
                firstIndexLargest++
            }
            i++
        }

        val smallElement = array[firstIndexLargest-1]
        array[firstIndexLargest-1] = array[pivot]
        array[firstIndexLargest] = smallElement
        firstIndexLargest++
    }
}