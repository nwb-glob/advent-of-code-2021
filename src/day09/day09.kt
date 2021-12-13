fun main() {

    /**
     * 0 means not edge
     * 1 means corner
     * 2 means edge
     */
    fun determineIfEdge(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Int{
        if(row == 0 || row == heatmap.size-1){
            if(col == 0 || col == heatmap[row].size - 1){
                return 1
            }else{
                return 2
            }
        }

        if(col == 0 || col == heatmap[row].size - 1){
            return 2
        }
        return 0
    }


    fun checkLeft(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        return heatmap[row][col] < heatmap[row][col-1]
    }

    fun checkRight(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        return heatmap[row][col] < heatmap[row][col+1]
    }

    fun checkUp(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        return heatmap[row][col] < heatmap[row-1][col]
    }

    fun checkDown(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        return heatmap[row][col] < heatmap[row+1][col]
    }

    fun checkCorner(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        if(row == 0){
            //top left corner
            return if(col == 0){
                checkDown(row,col,heatmap) && checkRight(row,col,heatmap)
            }
            //top right corner
            else {
                checkDown(row,col,heatmap) && checkLeft(row,col,heatmap)
            }
        }
        else {
            //bottom left corner
            return if(col == 0){
                checkUp(row,col,heatmap) && checkRight(row,col,heatmap)
            }
            //bottom right corner
            else {
                checkUp(row, col, heatmap) && checkLeft(row, col, heatmap)
            }
        }
    }


    fun checkEdge(row:Int, col:Int, heatmap: MutableList<MutableList<Int>>): Boolean{
        //top
        if(row == 0){
            return checkDown(row, col, heatmap) && checkLeft(row, col, heatmap) && checkRight(row, col, heatmap)
        }
        //bottom
        else if(row == heatmap.size - 1){
            return checkUp(row, col, heatmap) && checkLeft(row, col, heatmap) && checkRight(row, col, heatmap)
        }
        //left
        else if(col == 0){
            return checkUp(row, col, heatmap) && checkDown(row, col, heatmap) && checkRight(row, col, heatmap)
        }
        //right
        else {
            return checkUp(row, col, heatmap) && checkDown(row, col, heatmap) && checkLeft(row, col, heatmap)
        }
    }

    fun part1(heatmap: MutableList<MutableList<Int>>): Int {
        var riskLevel = 0
        for(row in heatmap.indices){
            for(col in heatmap[row].indices){
                when(determineIfEdge(row,col,heatmap)){
                    0 -> {
                        if(checkUp(row, col, heatmap) && checkDown(row, col, heatmap) && checkLeft(row, col, heatmap) && checkRight(row, col, heatmap)){
                            riskLevel += (heatmap[row][col] + 1)
                        }
                    }
                    1 -> {
                        if(checkCorner(row,col,heatmap)){
                            riskLevel += heatmap[row][col] + 1
                        }
                    }
                    2 -> {
                        if(checkEdge(row, col, heatmap)){
                            println("Edge is low point at $row, $col")
                            riskLevel += heatmap[row][col] + 1
                        }
                    }
                }
            }
        }

        return riskLevel

    }


    var input = readInput("day09/day09")
    var heatMap = mutableListOf<MutableList<Int>>()
    for(row in input.indices){
        var splitRow = input[row].toCharArray()
        for(number in splitRow){
            if(heatMap.size == row){
                heatMap.add(mutableListOf<Int>())
            }
            heatMap[row].add(number.toString().toInt())
        }
    }
    println(part1(heatMap))
}