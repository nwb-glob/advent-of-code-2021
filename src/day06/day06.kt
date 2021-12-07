fun main() {

    fun part1(input: List<Int>,days: Int): Long{
        var groups = input.groupBy { it }
        var totals = mutableListOf<Long>(0,0,0,0,0,0,0,0,0)

        for(i in  0..6){
            if(!groups[i].isNullOrEmpty()){
                totals[i] = groups[i]!!.size.toLong()
            }
        }

        for(day in 0 until days){
            var temp = totals[8]
            totals[8] = totals[0]
            for(i in 1..6){
                totals[i-1] = totals[i]
            }
            totals[6] = totals[8] + totals[7]
            totals[7] = temp
        }

        var answer:Long = 0
        for(i in 0 until totals.size){
            answer += totals[i]
        }
        return answer
    }



    val input = readInput("day06/day06")
    var splitInput: List<String> = input[0].split(",").toMutableList()
    var cleanedInput: MutableList<Int> = mutableListOf()
    splitInput.forEach{ it -> cleanedInput.add(it.toInt())}
    println(part1(cleanedInput,80))
    println(part1(cleanedInput,256))

}