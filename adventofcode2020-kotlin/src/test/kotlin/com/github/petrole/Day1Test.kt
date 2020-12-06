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

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day1Test  {

    lateinit var adventDay1 : Day1

    @BeforeAll
    fun setUp(){
        adventDay1 = Day1()
    }

    @Test
    fun partOneTest(){
        // Arrange
        val testInputTextLines = listOf("1009","1216","898","1333","1010","789","1122","577")
        // Act
        val result = adventDay1.solvePartOne(testInputTextLines)
        // Assert
        val expectedResult = "1007556"  // from 898 * 1122
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun partTwoTest(){
        // Arrange
        val testInputTextLines = listOf("1009","1216","898","1333","545","1010","789","1122","577","123")
        // Act
        val result = adventDay1.solvePartTwo(testInputTextLines)
        // Assert
        val expectedResult = "282389570" // from 898 * 545 * 577
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }
}
