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
class Day3(
    /**
     *
     */
    var inputLines: List<String>
) : AdventPuzzle {

    companion object {
        private val SLOPE_1_TO_1: Pair<Int, Int> = 1 to 1
        private val SLOPE_1_TO_2: Pair<Int, Int> = 1 to 2
        private val SLOPE_3_TO_1: Pair<Int, Int> = 3 to 1
        private val SLOPE_5_TO_1: Pair<Int, Int> = 5 to 1
        private val SLOPE_7_TO_1: Pair<Int, Int> = 7 to 1
    }

    private fun countTreesEncountered(vararg slopes: Pair<Int, Int>): Long {
        val treesCount = IntArray(slopes.size)
        inputLines.forEachIndexed { i, line ->
            slopes.forEachIndexed { j, (right, down) ->
                if (i % down == 0 && line[i / down * right % line.length] == '#') {
                    treesCount[j]++
                }
            }
        }
        return treesCount.fold(1L) { acc, elem -> acc * elem }
    }

    override fun solvePartOne(): String {
        return countTreesEncountered(SLOPE_3_TO_1).toString()
    }

    override fun solvePartTwo(): String {
        return countTreesEncountered(SLOPE_1_TO_1, SLOPE_3_TO_1, SLOPE_5_TO_1, SLOPE_7_TO_1, SLOPE_1_TO_2).toString()
    }


}
