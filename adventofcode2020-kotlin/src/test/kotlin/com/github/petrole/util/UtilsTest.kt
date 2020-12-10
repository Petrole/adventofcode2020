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

package com.github.petrole.util

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilsTest {

    @Test
    fun testLoadInputAsText() {
        // Arrange
        val testFileName = "test_file.txt"
        // Act
        val result = LoadInputAsText[testFileName]
        // Assert
        val expectedResult = "YOLO\r\n" + "420\r\n"
        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun testLoadInputAsLines() {
        // Arrange
        val testFileName = "test_file.txt"
        // Act
        val result = LoadInputAsLines[testFileName]
        // Assert
        val expectedResult = listOf("YOLO", "420")
        assertThat(result).isEqualTo(expectedResult)
    }
}