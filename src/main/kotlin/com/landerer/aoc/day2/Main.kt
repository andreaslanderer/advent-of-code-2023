package com.landerer.aoc.day2

import com.landerer.aoc.utils.readFileAsLines

fun main() {
    val files = mapOf(
        "Test" to "day_02_game_results_small.txt",
        "Exercise" to "day_02_game_results_large.txt")
    for ((name, file) in files) {
        val game = readFileAsLines(file)
        val config = GameConfiguration(14, 13, 12)
        val sumOfValidGames = Game(config, game).getSumOfValidGameIds()
        println("$name: The sum of all valid games is: $sumOfValidGames")
    }
}