package searching

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

object VowelAndConsonantTest {
    @Test
    fun test1(){
        val output = VowelAndConsonant.run(word = "aeioqq", k = 1)
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun test2(){
        val output = VowelAndConsonant.run(word = "aeiou", k = 0)
        assertThat(output).isEqualTo(1)
    }

    @Test
    fun test3(){
        val output = VowelAndConsonant.run(word = "ieaouqqieaouqq", k = 1)
        assertThat(output).isEqualTo(3)
    }

    @Test
    fun test4(){
        val output = VowelAndConsonant.run(word = "auoeia", k = 0)
        assertThat(output).isEqualTo(3)
    }

    @Test
    fun test5(){
        val output = VowelAndConsonant.run(word = "hoiuafoehh", k = 3)
        assertThat(output).isEqualTo(3)
    }
}