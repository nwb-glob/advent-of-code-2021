class Line(var input: String){

    var corruptChar: Char = ' '
    var queue = ArrayDeque<Char>()
    var openSymbols = listOf<Char>('(','[','{','<')
    var completionString = ""

    fun isCorrupt(): Boolean {
        for(char in input.toCharArray()){
            if(openSymbols.contains(char) ){
                queue.add(char)
            } else {
                var open = ' '
                when(char){
                    ')' -> {
                        open = queue.removeLast()
                        if(open != '('){
                            corruptChar = char
                            return true
                        }
                    }
                    ']' -> {
                        open = queue.removeLast()
                        if(open != '['){
                            corruptChar = char
                            return true
                        }
                    }
                    '}' -> {
                        open = queue.removeLast()
                        if(open != '{'){
                            corruptChar = char
                            return true
                        }
                    }
                    '>' -> {
                        open = queue.removeLast()
                        if(open != '<'){
                            corruptChar = char
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    fun buildCompletionString(){
        var char = ' '
        while(queue.lastOrNull() != null){
            char = queue.removeLast()
            when(char){
                '(' -> {
                    completionString += ")"
                }
                '[' -> {
                    completionString += "]"
                }
                '{' -> {
                    completionString += "}"
                }
                '<' -> {
                    completionString += ">"
                }
            }
        }
    }

    fun getCompletionScore(): Long{
        this.buildCompletionString()
        var score:Long = 0
        for(char in completionString.toCharArray()){
            score *= 5
            when(char){
                ')' -> {
                    score += 1
                }
                ']' -> {
                    score += 2
                }
                '}' -> {
                    score += 3
                }
                '>' -> {
                    score += 4
                }
            }
        }
        return score
    }



}

fun main(){

    fun part1(input: List<String>): Int {
       var points = 0

        for(line in input){
            var temp = Line(line)
            if(temp.isCorrupt()){
                when(temp.corruptChar){
                    ')' -> {
                        points += 3
                    }
                    ']' -> {
                        points += 57
                    }
                    '}' -> {
                        points += 1197
                    }
                    '>' -> {
                        points += 25137
                    }
                }
            }
        }
        return points
    }

    fun part2(input: List<String>): Long {
        var pointsList = mutableListOf<Long>()

        for(line in input){
            var temp = Line(line)
            if(!temp.isCorrupt()){
                pointsList.add(temp.getCompletionScore())
            }
        }
        pointsList.sort()
        return pointsList[(pointsList.size/2)]
    }


    var input = readInput("day10/day10")
    println(part1(input))
    println(part2(input))

}