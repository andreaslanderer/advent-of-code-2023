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
            val digit = getAsDigit(line, left)
            if (digit != null) {
                return digit
            }
            left++
        }
        throw RuntimeException("Missing digit in line: $line")
    }

    private fun getRightDigit(line: String): Int {
        var right = line.length - 1
        while (right >= 0) {
            val digit = getAsDigit(line, right)
            if (digit != null) {
                return digit
            }
            right--
        }
        throw RuntimeException("Missing digit in line: $line")
    }

    private fun getAsDigit(line: String, index: Int): Int? {
        if (line[index].isDigit()) {
            return line[index].digitToInt()
        } else if (line.indexOf("one", index) == index) {
            return 1
        } else if (line.indexOf("two", index) == index) {
            return 2
        } else if (line.indexOf("three", index) == index) {
            return 3
        } else if (line.indexOf("four", index) == index) {
            return 4
        } else if (line.indexOf("five", index) == index) {
            return 5
        } else if (line.indexOf("six", index) == index) {
            return 6
        } else if (line.indexOf("seven", index) == index) {
            return 7
        } else if (line.indexOf("eight", index) == index) {
            return 8
        } else if (line.indexOf("nine", index) == index) {
            return 9
        }
        return null
    }
}