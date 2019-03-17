package com.compile.spg

import com.compile.spg.CharMatrix.Companion.EQUALS
import com.compile.spg.CharMatrix.Companion.GREAT
import com.compile.spg.CharMatrix.Companion.LESS
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class CharMatrixTest {

    private lateinit var matrix: CharMatrix

    @Before
    fun init() {
        this.matrix = CharMatrix()
    }

    @Test
    fun getByIndexTest() {
        assertEquals(matrix.getByIndex('W', 'X'), EQUALS)
        assertEquals(matrix.getByIndex('W', 'W'), LESS)
        assertEquals(matrix.getByIndex('W', 'G'), LESS)
        assertEquals(matrix.getByIndex('W', 'x'), LESS)
        assertEquals(matrix.getByIndex('x', 'x'), GREAT)
        assertEquals(matrix.getByIndex('x', 'X'), GREAT)
    }
}