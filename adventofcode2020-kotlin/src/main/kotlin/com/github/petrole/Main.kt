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

import com.github.petrole.util.LoadInputAsLines
import org.reflections.Reflections
import java.io.IOException
import java.lang.invoke.MethodHandles
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue


/**
 * Empty String while waiting for lib fix.
 * See @ [https://github.com/ronmamo/reflections/issues/273](https://github.com/ronmamo/reflections/issues/273)
 */
val reflections = Reflections("")

private fun findAllAdventPuzzleImplInterfaces(): MutableSet<Class<out AdventPuzzle>>? {
    return reflections.getSubTypesOf(AdventPuzzle::class.java)
}

fun solveAllDays(){
    val allDayClasses = findAllAdventPuzzleImplInterfaces()
        ?: throw NullPointerException("Couldn't find day classes - please check directory .")

    allDayClasses.forEach { println(it.simpleName) }
}

fun main() {
    solveAllDays()
    val adventDay3 = Day3(LoadInputAsLines["input_day_3.txt"])

    val resultPart1 = adventDay3.solvePartOne()
    println("Part 1 result : $resultPart1")

    val resultPart2 = adventDay3.solvePartTwo()
    println("Part 2 result : $resultPart2")
}