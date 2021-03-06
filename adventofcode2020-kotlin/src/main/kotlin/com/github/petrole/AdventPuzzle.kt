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

import kotlin.time.measureTimedValue

/**
 *
 */
interface AdventPuzzle {

    companion object {
        /**
         * String to use when appropriate and when no solution is found.
         */
        const val NO_SOLUTION_FOUND: String = "No solution found."
    }

    /**
     *
     */
    fun solvePartOne(): String

    /**
     *
     */
    fun solvePartTwo(): String


    fun solvePartOneTimed() {
        println("Part 1 result : ${measureTimedValue { this.solvePartOne() }}")
    }

    fun solvePartTwoTimed() {
        println("Part 2 result : ${measureTimedValue { this.solvePartTwo() }}\n")
    }
}