package com.compile.spg

import com.compile.spg.Spg.Companion.MARKER
import org.springframework.stereotype.Service

@Service
class CharMatrix {
    private val indexes = "SAXBWGacbx"
    private val array = Array(10) { Array(10) { 0 } }

    init {
        array[4][2] = EQUALS
        array[4][4] = LESS
        array[4][5] = LESS
        array[4][9] = LESS
        array[5][9] = EQUALS
        array[6][1] = EQUALS
        array[6][2] = EQUALS
        array[6][4] = LESS
        array[6][5] = LESS
        array[6][7] = LESS
        array[6][8] = LESS
        array[6][9] = LESS
        array[7][3] = EQUALS
        array[7][6] = EQUALS
        array[7][8] = LESS
        array[8][0] = EQUALS
        array[8][1] = EQUALS
        array[8][6] = EQUALS
        array[8][7] = LESS
        array[8][8] = LESS
        array[9][2] = GREAT
        array[9][4] = GREAT
        array[9][5] = GREAT
        array[9][9] = GREAT
    }

    fun getByIndex(x: Char, y: Char): Int {
        return when {
            x == MARKER -> LESS
            y == MARKER -> GREAT
            else -> array[indexes.indexOf(x)][indexes.indexOf(y)]
        }
    }

    fun printArray() {
        array.forEach { ints ->
            run {
                ints.forEach { i -> print("$i ") }
                println()
            }
        }
    }

    companion object {
        const val EQUALS = 1
        const val LESS = 2
        const val GREAT = 3
    }
}