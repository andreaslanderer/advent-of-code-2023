package com.landerer.aoc.day2

import java.awt.Color.blue
import java.awt.Color.green
import java.awt.Color.red

class Game(private val configuration: GameConfiguration,
           private val history: List<String>) {

    fun getValidGameIds(): List<Int> {
        val ids = mutableListOf<Int>()
        for (prevGame in history) {
            val record = parseGameRecord(prevGame)
            var valid = true
            for (result in record.results) {
                if (isGameInvalid(result)) {
                    valid = false
                }
            }
            if (valid) {
                ids.add(record.id)
            }
        }
        return ids
    }

    fun getSumOfValidGameIds(): Int {
        val validGameIds = this.getValidGameIds()
        return validGameIds.fold(0) { a, b -> a + b}
    }

    private fun isGameInvalid(result: GameResult): Boolean {
        return result.blue > configuration.blueCubes
                || result.green > configuration.greenCubes
                || result.red > configuration.redCubes
    }

    private fun parseGameRecord(game: String): GameRecord {
        // decompose the string pattern 'Game n: <game result list>' into two components:
        // (1) 'Game n' and (2) '<game result list>'
        val gameComponents = game.split(": ")
        val id = gameComponents[0].split(" ")[1].toInt()

        // split the <game result list> into each individual result entries
        val results = gameComponents[1].split("; ")
        val gameResults = results.map(this::parseGameResult)
        return GameRecord(id, gameResults)
    }

    private fun parseGameResult(result: String): GameResult {
        val components = result.split(", ")
        var blue = 0
        var green = 0
        var red = 0
        for (component in components) {
            val cubes = component.split(" ")
            if (cubes[1] == "blue") {
                blue = cubes[0].toInt()
            } else if (cubes[1] == "green") {
                green = cubes[0].toInt()
            } else {
                red = cubes[0].toInt()
            }
        }
        return GameResult(blue,green,red)
    }
}

private data class GameRecord(val id: Int, val results: List<GameResult>)

private data class GameResult(val blue: Int, val green: Int, val red: Int)