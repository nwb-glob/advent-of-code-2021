import kotlin.math.absoluteValue

fun main(){


    fun part1(army: MutableList<Int>):Int {
        army.sort()
        var median = army[army.size/2]
        var fuelCost = 0
        for(crab in army){
            fuelCost += (crab-median).absoluteValue
        }
        return fuelCost
    }

    fun part2(army: MutableList<Int>): Int {
        var cost = Int.MAX_VALUE
        for(i in army.minOf { it } .. army.maxOf { it }){
            var tempCost = 0
            for(crab in army){
                var n = (i-crab).absoluteValue
                tempCost += (n * (n+1) / 2)
            }
            cost = minOf(cost,tempCost)
        }
        return cost
    }


    var input = readInput("day07/day07")
    var crabArmyRaw = input[0].split(",")
    var crabArmy = mutableListOf<Int>()
    for(crab in crabArmyRaw){
        crabArmy.add(crab.toInt())
    }
    println(part1(crabArmy))
    println(part2(crabArmy))
}