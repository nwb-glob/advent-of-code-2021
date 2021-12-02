fun main() {
    fun part1(input: List<String>): Int {
        var values: List<Int> = input.map(String::toInt)
        var numIncreases: Int = 0
        for(i in 0 until values.size-1){
            if(values[i+1] > values[i])
                numIncreases++
        }
        return numIncreases
    }

    fun sumOfMeasurements(a: Int, b: Int, c: Int): Int {
        return a+b+c
    }

    fun part2(input: List<String>): Int {
        var values: List<Int> = input.map(String::toInt)
        var numIncreases: Int = 0
        for(i in 1 until input.size-2){
            if(sumOfMeasurements(values[i],values[i+1],values[i+2]) > sumOfMeasurements(values[i-1],values[i],values[i+1]))
                numIncreases++
        }
        return numIncreases
    }



    val input = readInput("day01/day01")
    println(part1(input))
    println(part2(input))
}
