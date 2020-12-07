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
 *
 * I dedicate this puzzle to Kanye West.
 */
class Day2(var inputLines: List<String>) : AdventPuzzle {

    private val regexPattern = "(\\d*)-(\\d*) ([a-zA-Z]): ([a-zA-Z]*)".toRegex()

    private data class KanyeWest(val minPolicy: Int, val maxPolicy: Int, val letterPolicy: Char, val password: String)

    private val kanyes by lazy {
        inputLines.map {
            val (minPolicy, maxPolicy, letterPolicy, password) = regexPattern.find(it)?.destructured!!
            KanyeWest(minPolicy.toInt(), maxPolicy.toInt(), letterPolicy.single(), password)
        }
    }

    override fun solvePartOne(): String {
        return kanyes.count { (minPolicy, maxPolicy, letterPolicy, password) ->
            (password.count { it == letterPolicy } in minPolicy..maxPolicy)
        }.toString()
    }

    override fun solvePartTwo(): String {
        return kanyes.count { (minPolicy, maxPolicy, letterPolicy, password) ->
            (password[minPolicy - 1] == letterPolicy) != (password[maxPolicy - 1] == letterPolicy)
        }.toString()
    }
}

