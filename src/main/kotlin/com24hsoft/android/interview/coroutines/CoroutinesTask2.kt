package com24hsoft.android.interview.coroutines

import kotlinx.coroutines.*

/**
 * Дописать функцию printSync таким образом, чтобы функция printValue вызывалась последовательно
 */
class ValuePrinter {

    fun print() {
        val scope = CoroutineScope(Dispatchers.IO)
        repeat(10) { value ->
            scope
                .launch {
                    printValue(value)
                }
        }
    }

    fun printSequentially() {
        repeat(10) { value ->
            TODO()
        }
    }

    private suspend fun printValue(value: Int) {
        delay(100)
        println("Printed value $value")
    }
}

fun main() {
    val printer = ValuePrinter()
    runBlocking {
        printer.print()
        delay(2100)
    }
}