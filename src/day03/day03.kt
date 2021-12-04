import java.util.*

fun main() {

    fun part1(input: List<String>): Int{
        var gamma: String = ""
        var epsilon: String = ""
        var bitCount: IntArray = IntArray(input[0].length)

        for(curr in input){
            for(i in 0 until curr.length){
                if(curr[i] == '1'){
                    bitCount[i] += 1
                } else {
                    bitCount[i] -= 1
                }
            }
        }

        for(i in 0 until bitCount.size){
            if(bitCount[i] > 0){
                gamma += "1"
                epsilon += "0"
            } else {
                gamma += "0"
                epsilon += "1"
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)

    }

    fun part2(input: List<String>): Int {
        var currListOx: List<String> = input
        var currListC02: List<String> = input
        var pos = 0
        var ones: ArrayList<String> = ArrayList<String>()
        var zeros: ArrayList<String> = ArrayList<String>()


        while (currListOx.size > 1){
            for (i in 0 until currListOx.size) {
                if (currListOx[i].get(pos) == '1') {
                    ones.add(currListOx[i])
                } else {
                    zeros.add(currListOx[i])
                }
            }
            if(ones.size >= zeros.size){
                currListOx = ones
            } else {
                currListOx = zeros
            }
            ones = ArrayList<String>()
            zeros = ArrayList<String>()
            pos++
        }

        pos = 0

        while (currListC02.size > 1){
            for (i in 0 until currListC02.size) {
                if (currListC02[i].get(pos) == '1') {
                    ones.add(currListC02[i])
                } else {
                    zeros.add(currListC02[i])
                }
            }
            if(ones.size >= zeros.size){
                currListC02 = zeros
            } else {
                currListC02 = ones
            }
                ones = ArrayList<String>()
                zeros = ArrayList<String>()
                pos++
        }

        println("ox is ${currListOx[0]} and c02 is ${currListC02[0]}")

        return currListOx[0].toInt(2) * currListC02[0].toInt(2)



    }


    val input = readInput("day03/day03")
    println(part1(input))
    println(part2(input))

}