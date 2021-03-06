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

import java.io.IOException
import java.io.InputStream
import java.lang.invoke.MethodHandles


/**
 * Various utility singletons and methods used for the advent of code puzzles.
 */
fun String.getMatchingResourceAsStream(): InputStream {
    return MethodHandles.lookup().lookupClass().classLoader.getResourceAsStream(this)
        ?: throw IOException("Cannot find file : please check the path, file status or classpath settings.")
}

/**
 *
 */
object LoadInputAsLines {
    /**
     * Retrieves all lines of a file of the given name as a list. Use UTF-8.
     */
    operator fun get(name: String): List<String> {
        return name.getMatchingResourceAsStream().bufferedReader(Charsets.UTF_8).readLines()
    }
}

/**
 *
 */
object LoadInputAsText {
    /**
     * Retrieves all the content of a file as a string. Use UTF-8.
     */
    operator fun get(name: String): String {
        return name.getMatchingResourceAsStream().bufferedReader(Charsets.UTF_8).use { it.readText() }
    }
}
