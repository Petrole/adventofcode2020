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
 * Problem description @ [https://adventofcode.com/2020/day/2](https://adventofcode.com/2020/day/2)
 */
class Day2(var inputLines: List<String>) : AdventPuzzle {

    private val regexPattern = "(\\d*)-(\\d*) ([a-zA-Z]): ([a-zA-Z]*)".toRegex()

    override fun solvePartOne(): String {
        var numberOfValidPasswords = 0
        for (line in inputLines) {
            val lineGroups = regexPattern.find(line)?.destructured
            if (lineGroups != null) {
                val minPolicy = lineGroups.component1().toInt()
                val maxPolicy = lineGroups.component2().toInt()
                val letterPolicy = lineGroups.component3().single()
                val password = lineGroups.component4()
                if (password.filter { it == letterPolicy }.count() in minPolicy..maxPolicy)
                    numberOfValidPasswords += 1
            }
        }
        return numberOfValidPasswords.toString()
    }

    override fun solvePartTwo(): String {
        var numberOfValidPasswords = 0
        for (line in inputLines) {
            val lineGroups = regexPattern.find(line)?.destructured
            if (lineGroups != null) {
                val minPolicy = lineGroups.component1().toInt()
                val maxPolicy = lineGroups.component2().toInt()
                val letterPolicy = lineGroups.component3().single()
                val password = lineGroups.component4()
                if (password.filter { it == letterPolicy }.count() > 0
                    && ((password[minPolicy - 1] == letterPolicy)
                        .xor(password[maxPolicy - 1] == letterPolicy))
                ) {
                    numberOfValidPasswords += 1

                }
            }
        }
        return numberOfValidPasswords.toString()
    }
}

