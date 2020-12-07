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
class Day1(var inputLines: List<String>) : AdventPuzzle {

    private val targetSum = 2020

    override fun solvePartOne(): String {
        val expenseReport = inputLines.map { it.toInt() }.toSet()
        return try {
            val a = expenseReport.first {  2020 - it in expenseReport}
            (a*(2020-a)).toString()
        } catch (e:Exception){
            System.err.println("Exception : ${e.message}")
            "No solution found."
        }
    }

    override fun solvePartTwo(): String {
        val expenseReport: List<Int> = inputLines.map { it.toInt() }
        for (i in expenseReport.indices) {
            for (j in (i + 1)..expenseReport.lastIndex) {
                for (k in (j + 1)..expenseReport.lastIndex) {
                    if (expenseReport[i] + expenseReport[j] + expenseReport[k] == targetSum) {
                        return (expenseReport[i] * expenseReport[j] * expenseReport[k]).toString()
                    }
                }
            }
        }
        return "No solution found."
    }
}
