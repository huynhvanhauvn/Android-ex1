object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        if(factors.isEmpty() || limit == 1){
            return 0
        }
        var listResult : MutableList<Int> = ArrayList()
        for(i in 1 until limit) {
            for(factor in factors) {
                if (factor != 0) {
                    if (i % factor == 0) {
                        listResult.add(i)
                        break
                    }
                }
            }
        }
        var total = 0
        for(i in listResult.indices){
            total += listResult[i]
        }
        return total
    }
}
