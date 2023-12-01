package com.landerer.aoc.day1

import java.lang.RuntimeException

fun main() {
    val documents = arrayListOf("document.txt", "small_document_2.txt")
    for (document in documents) {
        val lines = readFileAsLines(document)
        val calibrationDocument = CalibrationDocument(lines.toTypedArray())
        var sum = 0
        do {
            val number = calibrationDocument.readNextValidationValue()
            if (number != null) {
                sum += number
            }
        } while (number != null)
        println("The sum of all calibration values is: $sum")
    }
}

private fun readFileAsLines(fileName: String): List<String> {
    val classLoader = Thread.currentThread().contextClassLoader
    val inputStream = classLoader.getResourceAsStream(fileName)
    return inputStream?.bufferedReader()?.readLines()
        ?: throw RuntimeException("Can't read file: $fileName")
}