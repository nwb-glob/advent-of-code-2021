fun main(){

    fun part1(input: List<String>): Int {
        var horiz = 0
        var depth = 0
        for(command in input){
            var firstChar = command.elementAtOrNull(0)
            if('u' == firstChar){
                depth -= command.subSequence(3, command.length).toString().toInt()
            } else if ('d' == firstChar) {
                depth += command.subSequence(5, command.length).toString().toInt()
            } else {
                horiz += command.subSequence(8, command.length).toString().toInt()
            }
        }
        return horiz*depth

    }


    fun part2(input: List<String>): Int {
        var horiz = 0
        var depth = 0
        var aim = 0
        for(command in input){
            var firstChar = command.elementAtOrNull(0)
            if('u' == firstChar){
                aim -= command.subSequence(3, command.length).toString().toInt()
            } else if ('d' == firstChar) {
                aim += command.subSequence(5, command.length).toString().toInt()
            } else {
                var x: Int = command.subSequence(8, command.length).toString().toInt()
                horiz += x
                depth += (aim*x)
            }
        }
        return horiz*depth

    }



    val input = readInput("day02/day02")
    println(part1(input))
    println(part2(input))
}