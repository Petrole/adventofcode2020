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

import com.github.petrole.util.getTextFromFile

/**
 * Problem description @ [https://adventofcode.com/2020/day/1](https://adventofcode.com/2020/day/1)
 */
class Day1 : AdventPuzzle {

    override fun loadPuzzleInput(fileName: String): List<String> {
        return fileName
            .getTextFromFile()
            .split("\n")
            .takeWhile { it.isNotBlank() }
    }

    override fun solvePartOne(inputTextLines: List<String>): String {
        val expenseReport: List<Int> = inputTextLines.map { it.toInt() }
        val targetSum = 2020
        for (i in expenseReport.indices) {
            for (j in (i + 1)..expenseReport.lastIndex) {
                if (expenseReport[i] + expenseReport[j] == targetSum) {
                    return (expenseReport[i] * expenseReport[j]).toString()
                }
            }
        }
        return "No solution found."
    }

    override fun solvePartTwo(inputTextLines: List<String>): String {
        val expenseReport: List<Int> = inputTextLines.map { it.toInt() }
        val targetSum = 2020
        // we have nice computers now,
        // maybe not so in poorer places,
        // but i dont care and im lazy,
        // still, if we compute a+b+c and then a+b+d , a+b+e, ...,  we should cache the result of a+b and so on
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
