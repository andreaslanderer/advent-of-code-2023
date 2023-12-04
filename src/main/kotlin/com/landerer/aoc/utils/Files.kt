package com.landerer.aoc.utils

import java.lang.RuntimeException

fun readFileAsLines(fileName: String): List<String> {
    val classLoader = Thread.currentThread().contextClassLoader
    val inputStream = classLoader.getResourceAsStream(fileName)
    return inputStream?.bufferedReader()?.readLines()
        ?: throw RuntimeException("Can't read file: $fileName")
}