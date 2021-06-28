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
@file:Suppress("unused")

package com.github.petrole

import com.github.petrole.util.LoadInputAsLines
import org.reflections.Reflections

/**
 *
 */
object AdventPuzzleSolver {
    /**
     * Empty String while waiting for lib fix.
     * See @ [https://github.com/ronmamo/reflections/issues/273](https://github.com/ronmamo/reflections/issues/273)
     */
    private val reflections = Reflections("")

    private fun getAllAdventPuzzleImplInterfaces(): MutableSet<Class<out AdventPuzzle>> {
        return reflections.getSubTypesOf(AdventPuzzle::class.java)
            ?: throw NoSuchElementException("Couldn't find day classes - please check directory .")
    }

    private fun inputDay(day: Int): String {
        return "input_day_${day}.txt"
    }

    private fun Class<out AdventPuzzle>.getNewInstanceOf(day: Int): AdventPuzzle {
        return this.constructors[0].newInstance(LoadInputAsLines[inputDay(day)]) as AdventPuzzle
    }

    private fun getSpecificDay(day: Int): AdventPuzzle {
        return getAllAdventPuzzleImplInterfaces()
            .first { it.simpleName.contains(day.toString()) }
            .getNewInstanceOf(day)
    }

    /**
     *
     */
    fun solveAllDays() {
        getAllAdventPuzzleImplInterfaces()
            .forEachIndexed { dayIndex, clazz ->
                clazz.getNewInstanceOf(dayIndex + 1)
                    .run {
                        println(clazz.simpleName)
                        solvePartOneTimed()
                        solvePartTwoTimed()
                    }
            }
    }

    /**
     *
     */
    fun solveDay(day: Int) {
        getSpecificDay(day).run {
            println(this::class.simpleName)
            solvePartOneTimed()
            solvePartTwoTimed()
        }
    }

    /**
     *
     */
    fun solveDayPart1(day: Int) {
        getSpecificDay(day).run {
            println(this::class.simpleName)
            solvePartOneTimed()
        }
    }

    /**
     *
     */
    fun solveDayPart2(day: Int) {
        getSpecificDay(day).run {
            println(this::class.simpleName)
            solvePartTwoTimed()
        }
    }

}



