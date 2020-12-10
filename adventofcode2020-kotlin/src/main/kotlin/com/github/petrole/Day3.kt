/*
 * MIT License
 * 
 * Copyright (c) [2020] [Petrole] - All rights reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.petrole

/**
 * Problem description @ [https://adventofcode.com/2020/day/3](https://adventofcode.com/2020/day/3)
 */
class Day3(var inputLines: List<String>) : AdventPuzzle {

    private fun countTreesEncountered(vararg slopes: Pair<Int, Int>): Long {
        val treesCount = IntArray(slopes.size)
        inputLines.forEachIndexed { i, line ->
            println("\n1st foreach i: $i / line: $line")
            slopes.forEachIndexed { j, (right, down) ->
                println("2nd foreach j: $j / over: $right / down: $down")
                println(
                    "line[i / down * right % line.length] = ${line[i / down * right % line.length]} , with i:$i down:$down right:$right " +
                            "line.length:${line.length}  i/down:${i / down} i/down*right:${i / down * right}  " +
                            "right%line:${right % line.length} calc:${down * right % line.length}"
                )
                if (i % down == 0 && line[i / down * right % line.length] == '#') {
                    treesCount[j]++
                    println("found tree")
                }
            }
        }
        return treesCount.fold(1L) { acc, elem -> acc * elem }
    }

    override fun solvePartOne(): String {
        return countTreesEncountered(3 to 1).toString()
    }

    override fun solvePartTwo(): String {
        return countTreesEncountered(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2).toString()
    }


}