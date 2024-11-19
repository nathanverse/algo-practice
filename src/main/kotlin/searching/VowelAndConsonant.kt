package searching

object VowelAndConsonant {
    /**
     * 3306. Count of Substrings Containing Every Vowel and K Consonants II
     * You are given a string word and a non-negative integer k.
     *
     * Return the total number of
     * substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
     */

    val VOWEL = listOf('a', 'e', 'i', 'o', 'u')

    private fun isVowel(c: Char): Boolean{
        return VOWEL.contains(c)
    }

    private fun MutableMap<Char, Int>.increaseFrequency(
        c: Char
    ){
        if(!this.containsKey(c)){
            this[c] = 1
        } else {
            this[c] = this[c]!! + 1
        }
    }

    private fun MutableMap<Char, Int>.decreaseFrequency(
        c: Char
    ){
        if(!this.containsKey(c)){
            return
        }

        if(this[c] == 1){
            this.remove(c)
        } else {
            this[c] = this[c]!! - 1
        }
    }


    fun run(word: String, k: Int): Long {
        if(k > word.length || k < 0){
            return 0
        }

        val nextConsonantArray = MutableList(word.length) { word.length }

        var count = 0
        while(count < word.length){
            if(!isVowel(word[count])){
                var tempIndex = count - 1
                while(tempIndex >= 0 && nextConsonantArray[tempIndex] == word.length ){
                    nextConsonantArray[tempIndex] = count
                    tempIndex -= 1
                }
            }

            count += 1
        }

        var right = 0
        var left = 0
        var consonantCount = 0
        val vowelFrequencyMap = mutableMapOf<Char, Int>()
        var result : Long = 0

        while(left <= right && right < word.length){
            if(isVowel(word[right])){
                vowelFrequencyMap.increaseFrequency(word[right])
            } else {
                consonantCount += 1
            }

            // We slide the left cursor if the condition has not been met
            while(consonantCount > k && left < right){
                if(isVowel(word[left])){
                    vowelFrequencyMap.decreaseFrequency(word[left])
                } else {
                    consonantCount -= 1
                }
                left += 1
            }

            // Count the valid string
            while(
                consonantCount == k &&
                vowelFrequencyMap.size == 5 &&
                left <= right
            ) {
                result += nextConsonantArray[right] - right
                if(isVowel(word[left])){
                    vowelFrequencyMap.decreaseFrequency(word[left])
                } else {
                    consonantCount -= 1
                }
                left += 1
            }

            right += 1
        }

        return result
    }
}