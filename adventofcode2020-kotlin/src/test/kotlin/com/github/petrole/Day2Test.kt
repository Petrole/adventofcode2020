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
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day2Test : AdventPuzzleTest {

    private lateinit var adventDay2: Day2

    @BeforeEach
    override fun setUp() {
        adventDay2 = Day2(listOf())
    }

    @Test
    override fun partOneTest() {
        adventDay2.inputLines = listOf(
            "3-4 j: jjjjjjjnq",
            "5-6 h: pkhzhh",
            "5-6 g: gggggm",
            "1-6 j: djjjjjj",
            "4-5 c: xvfcfkfz"
        )

        val result = adventDay2.solvePartOne()

        val expectedResult = "2" // the 1st rule
        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    override fun partTwoTest() {
        // Arrange
        adventDay2.inputLines = listOf(
            "3-4 j: jjjjjjjnq",
            "5-6 h: pkhzhh",
            "5-6 g: gggggm",
            "1-6 j: djjjjjj",
            "4-5 c: xvfcfkfz"
        )
        // Act
        val result = adventDay2.solvePartTwo()
        // Assert
        val expectedResult = "3" // the 2nd rule
        assertThat(result).isEqualTo(expectedResult)
    }
}
