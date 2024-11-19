package org.example.others


interface Last2Digits{
    fun run(m: Int, n: Int): Int
}

/**
 * Given two integers m and n, return the last two digits of m^n
 */
object Last2DigitsMostOptimal : Last2Digits {
    override fun run(m: Int, n: Int): Int{
        if(n == 0 || m == 0) return 1

        var base = m % 100
        var result = 1
        var order = n

        while(order > 0){
            if(order % 2 == 1){
                result = (result * base) % 100
            }

            base = (base*base) % 100
            order /= 2
        }

        return result
    }
}

object Last2DigitsOn : Last2Digits{
    override fun run(m: Int, n: Int): Int{
        if(m == 0) return 0
        if(n == 0) return 1

        var order = n
        var temp = m
        if(m > 100){
            temp %= 100
        }
        while(order > 1){
            temp = (temp * m) % 100
            order -= 1
        }

        return temp
    }
}