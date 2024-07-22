import org.example.hash_table_13.FindNearestRepetition
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNearestRepetitionTest {
    companion object{
        val testCases = mapOf(
            listOf(
                "All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"
            ) to 2,
            listOf(
                "All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"
            ) to 1
        )
    }

    @Test
    fun solve(){
        testCases.forEach{ (input, result) ->
            println("Input: $input")
            assertEquals(FindNearestRepetition.findNearestRepetition(input), result)
        }
    }
}
