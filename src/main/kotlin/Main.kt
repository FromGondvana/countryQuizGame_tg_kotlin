package org.example


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BotApp

fun main() {
    println("START MAIN")
    runApplication<BotApp>()
}