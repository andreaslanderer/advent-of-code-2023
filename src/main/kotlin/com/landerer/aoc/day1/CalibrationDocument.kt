package com.landerer.aoc.day1

import java.lang.RuntimeException

class CalibrationDocument(private val calibrationValues: Array<String>) {

    private var index = 0

    fun readNextValidationValue(): Int? {
        return if (index < calibrationValues.size) getCalibrationValue(index++) else null
    }

    private fun getCalibrationValue(index: Int): Int {
        val line = calibrationValues[index]
        val leftDigit = getLeftDigit(line)
        val rightDigit = getRightDigit(line)
        return leftDigit * 10 + rightDigit
    }

    private fun getLeftDigit(line: String): Int {
        var left = 0
        while (left < line.length) {
            if (line[left].isDigit()) {
                return line[left].digitToInt()
            }
            left++
        }
        throw RuntimeException("Missing digit in line: $line")
    }

    private fun getRightDigit(line: String): Int {
        var right = line.length - 1
        while (right >= 0) {
            if (line[right].isDigit()) {
                return line[right].digitToInt()
            }
            right--
        }
        throw RuntimeException("Missing digit in line: $line")
    }
}