package org.example.heap

import java.util.PriorityQueue
import kotlin.math.min

/**
 * Write a program that takes as input a set of sorted sequences and computes the union of these sequences as a sorted sequence.
 * For example, if the input is (3, 5, 7), (0, 6), and (0, 6, 28), then the output is (0, 0, 3, 5, 6, 6, 7, 28).
 */
object MergeSortedFiles {
    class Node(
        val value: Int,
        val fileIndex: Int,
        val lineIndex: Int
    )


    fun run(
        files: List<List<Int>>
    ) : List<Int>{
        if(files.isEmpty()){
            throw IllegalArgumentException("Empty files")
        }

        if(files.size == 1){
            return files[0]
        }

        val heapArray = PriorityQueue<Node>(compareBy { it.value })

        files.forEachIndexed { fileIndex, file ->
            if(file.isNotEmpty()){
                heapArray.add(
                    Node(
                        value = file[0],
                        fileIndex = fileIndex,
                        lineIndex = 0
                    )
                )
            }
        }

        val concatenateFile = mutableListOf<Int>()
        while(heapArray.isNotEmpty()){
            val minTrade = heapArray.poll()
            concatenateFile.add(minTrade.value)

            if(files[minTrade.fileIndex].size - 1 > minTrade.lineIndex){
                 heapArray.add(
                     Node(
                         value = files[minTrade.fileIndex][minTrade.lineIndex + 1],
                         fileIndex = minTrade.fileIndex,
                         lineIndex = minTrade.lineIndex + 1
                     )
                 )
            }
        }

        return concatenateFile
    }
}