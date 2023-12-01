package com.landerer.aoc.day1

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TrebuchetTest {

    @Test
    fun `left and right digit are outer chars`() {
        val document = CalibrationDocument(arrayOf("1abc2"))
        assertThat(document.readNextValidationValue()).isEqualTo(12)
        assertThat(document.readNextValidationValue()).isNull()
    }

    @Test
    fun `left and right value are NOT outer chars`() {
        val document = CalibrationDocument(arrayOf("pqr3stu8vwx"))
        assertThat(document.readNextValidationValue()).isEqualTo(38)
    }

    @Test
    fun `multiple numbers`() {
        val document = CalibrationDocument(arrayOf("a1b2c3d4e5f"))
        assertThat(document.readNextValidationValue()).isEqualTo(15)
    }

    @Test
    fun `one number`() {
        val document = CalibrationDocument(arrayOf("treb7uchet"))
        assertThat(document.readNextValidationValue()).isEqualTo(77)
    }
}