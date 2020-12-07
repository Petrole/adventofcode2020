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


import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class Day1Test : AdventPuzzleTest {

    private lateinit var adventDay1: Day1

    @BeforeAll
    override fun setUp() {
        adventDay1 = Day1(listOf())
    }

    @Test
    override fun partOneTest() {
        adventDay1.inputLines = listOf("1009", "1216", "898", "1333", "545", "1010", "789", "1122", "577", "123")

        val result = adventDay1.solvePartOne()

        val expectedResult = "1007556"  // from 898 * 1122
        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    override fun partTwoTest() {
        adventDay1.inputLines = listOf("1009", "1216", "898", "1333", "545", "1010", "789", "1122", "577", "123")

        val result = adventDay1.solvePartTwo()

        val expectedResult = "282389570" // from 898 * 545 * 577
        assertThat(result).isEqualTo(expectedResult)
    }
}
