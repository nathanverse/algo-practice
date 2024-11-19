package others

import org.example.others.Last2Digits
import org.example.others.Last2DigitsMostOptimal
import org.example.others.Last2DigitsOn
import org.junit.jupiter.api.Test

class Last2Digits {
    private val last2Digits: Last2Digits = Last2DigitsOn
    @Test
    fun happyPath(){
        val m = 12
        val n = 4
        val expected = 36
        val actual = last2Digits.run(m, n)
        assert(expected == actual)
    }

    @Test
    fun test2(){
        val m = 10
        val n = 5
        val expected = 0
        val actual = last2Digits.run(m, n)
        assert(expected == actual)
    }

    @Test
    fun test3(){
        val m = 12345
        val n = 6789
        val expected = 25
        val actual = last2Digits.run(m, n)
        assert(expected == actual)
    }

    @Test
    fun test4(){
        val m = 12
        val n = 3
        val expected = 28
        val actual = last2Digits.run(m, n)
        assert(expected == actual)
    }

    @Test
    fun test5(){
        val m = 17
        val n = 19
        val expected = 53
        val actual = last2Digits.run(m, n)
        assert(expected == actual)
    }
}