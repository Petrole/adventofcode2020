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
 * Problem description @ [https://adventofcode.com/2020/day/1](https://adventofcode.com/2020/day/1)
 */
class Day1(
    /**
     * Input lines coming from the puzzle entry.
     */
    var inputLines: List<String>
) : AdventPuzzle {

    companion object {
        /**
         * Target sum for the puzzle.
         */
        const val TARGET_SUM: Int = 2020
    }

    override fun solvePartOne(): String {
        val report = inputLines.map { it.toInt() }.toSet()
        return try {
            val a = report.first { TARGET_SUM - it in report }
            (a * (TARGET_SUM - a)).toString()
        } catch (e: NoSuchElementException) {
            System.err.println("Exception : ${e.message}")
            AdventPuzzle.NO_SOLUTION_FOUND
        }
    }

    /** See 3SUM @ [https://en.wikipedia.org/wiki/3SUM](https://en.wikipedia.org/wiki/3SUM) */
    override fun solvePartTwo(): String {
        val report = inputLines.map { it.toInt() }.sorted().toIntArray()
        val n = report.size
        report.forEachIndexed { index, _ ->
            var start = index + 1
            var end = n - 1
            while (start < end) {
                val sum = report[start] + report[end] + report[index]
                when {
                    sum == TARGET_SUM -> return (report[start] * report[end] * report[index]).toString()
                    sum > TARGET_SUM  -> end--
                    else              -> start++

                }
            }
        }
        return AdventPuzzle.NO_SOLUTION_FOUND
    }
}
