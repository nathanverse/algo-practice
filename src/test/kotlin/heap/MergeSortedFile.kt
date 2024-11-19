package heap

import org.example.heap.MergeSortedFiles
import org.junit.jupiter.api.Test

object MergeSortedFile {
    @Test
    fun happyPath(){
        val input : List<List<Int>> = listOf(
            listOf(3, 5, 7),
            listOf(0, 6),
            listOf(0, 6, 28)
        )

        val expected = listOf(0, 0, 3, 5, 6, 6, 7, 28)

        assert(MergeSortedFiles.run(input) == expected)
    }
}