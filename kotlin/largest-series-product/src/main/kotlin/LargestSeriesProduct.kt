import java.lang.Double.parseDouble

class Series(input: String) {
    val numString = input

    init {
        if(!"^[0-9]*$".toRegex().matches(numString)){
            throw IllegalArgumentException("")
        }
    }

    fun getLargestProduct(span: Int): Long {
        if(span == 0){
            return 1
        }
        if(span > numString.length ){
            throw IllegalArgumentException("reject | nondigits in source sequence")
        }
        if((span != 0 && numString.isBlank()) || span < 0){
            throw IllegalArgumentException("")
        }
        if(span == numString.length){
            var total = 1
            for(i in numString.indices){
                total *= numString[i].toString().toInt()
            }
            return total.toLong()
        }else{
            var curTotal = 1
            var finalTotal = 0
            var curString = ""
            var startIndex = 0
            while (startIndex <= numString.length - span) {
                curString = numString.substring(startIndex, startIndex + span)
                curTotal = 1
                for(i in curString.indices){
                    curTotal *= curString[i].toString().toInt()
                }
                if(curTotal > finalTotal){
                    finalTotal = curTotal
                }
                startIndex++
            }
            return finalTotal.toLong()
        }
    }
}
