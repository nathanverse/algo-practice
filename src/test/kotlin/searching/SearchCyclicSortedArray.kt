package searching

import org.example.others.Last2Digits
import org.example.searching.SearchCyclicSortedArray
import org.junit.jupiter.api.Test

object SearchCyclicSortedArray {
    @Test
    fun happyPath(){
        val input = listOf(4, 5, 1, 2, 3)
        val expected = 2
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test2(){
        val input = listOf(5, 1, 2, 3, 4)
        val expected = 1
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test3(){
        val input = listOf(3, 4, 5, 1, 2)
        val expected = 3
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test4s(){
        val input = listOf(5, 5, 5,5,2)
        val expected = 4
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test5(){
        val input = listOf(4, 5, 5, 1, 2)
        val expected = 3
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test6(){
        val input = listOf(1)
        val expected = 0
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }

    @Test
    fun test7(){
        val input = listOf(9, 10, 2, 3, 4, 5, 6, 7, 8)
        val expected = 2
        val actual = SearchCyclicSortedArray.run(input)
        assert(expected == actual)
    }
}