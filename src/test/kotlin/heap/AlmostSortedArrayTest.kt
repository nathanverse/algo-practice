package heap

import org.example.heap.AlmostSortedArray
import org.junit.jupiter.api.Test

object AlmostSortedArrayTest {
    @Test
    fun happyPath(){
        val input = listOf(3,-1,2,6,4,5,8)
        val k = 2
        assert(AlmostSortedArray.run(elements = input, k = k) == "-1,2,3,4,5,6,8")
    }
}