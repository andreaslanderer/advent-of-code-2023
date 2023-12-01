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

    @Test
    fun `start with one`() {
        val document = CalibrationDocument(arrayOf("one2"))
        assertThat(document.readNextValidationValue()).isEqualTo(12)
    }

    @Test
    fun `end with two`() {
        val document = CalibrationDocument(arrayOf("13two"))
        assertThat(document.readNextValidationValue()).isEqualTo(12)
    }

    @Test
    fun `start with three`() {
        val document = CalibrationDocument(arrayOf("threeonetwo4"))
        assertThat(document.readNextValidationValue()).isEqualTo(34)
    }

    @Test
    fun `end with four`() {
        val document = CalibrationDocument(arrayOf("1ghdnt5four"))
        assertThat(document.readNextValidationValue()).isEqualTo(14)
    }

    @Test
    fun `start with five`() {
        val document = CalibrationDocument(arrayOf("five13"))
        assertThat(document.readNextValidationValue()).isEqualTo(53)
    }

    @Test
    fun `start with six and end with seven`() {
        val document = CalibrationDocument(arrayOf("six1seven"))
        assertThat(document.readNextValidationValue()).isEqualTo(67)
    }

    @Test
    fun `start with nine and end with eight`() {
        val document = CalibrationDocument(arrayOf("nine56eight"))
        assertThat(document.readNextValidationValue()).isEqualTo(98)
    }

    @Test
    fun `start with and end with two`() {
        val document = CalibrationDocument(arrayOf("twokdkcbhtqxfc87rkgctwo"))
        assertThat(document.readNextValidationValue()).isEqualTo(22)
    }
}