package org.example.hash_table_13

import kotlin.math.min

object FindNearestRepetition {
    /**
     * People do not like reading text in which a word is used multiple times in a
     * short paragraph. You are to write a program which helps identify such a problem.
     *
     * Write a program which takes as input an array and finds the distance between
     * the closest pair of equal entries. For example, if s = ("All", "work", "and", "no",
     * "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"), then
     * the second and third occurrences of "no" is the closest pair.
     */
    fun findNearestRepetition(
        paragraph: List<String>
    ): Int{
        var minDistance = Integer.MAX_VALUE
        val wordMap : HashMap<String, Int> = hashMapOf()
        for((index, word) in paragraph.withIndex()){
            val lastIndexAppear = wordMap[word]
            if(lastIndexAppear != null){
                minDistance = min(minDistance, index - lastIndexAppear)
            }
            // Store latest encountered index
            wordMap[word] = index
        }

        return minDistance
    }
}

