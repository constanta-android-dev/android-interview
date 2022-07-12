package com24hsoft.android.interview.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * Внести изменения в функцию getAllData таким образом, чтобы она вернула список,
 * содержащий все элементы, добавленные итерацией в scope1 и scope2. При этом, нельзя убирать ни один из скоупов
 */
class SomeDataGetter {

    fun getAllData(): List<Int> {
        val toReturn = mutableListOf<Int>()
        val scope1 = CoroutineScope(Dispatchers.IO)
        val scope2 = CoroutineScope(Dispatchers.Default)
        scope1
            .launch {
                (1..10)
                    .forEach {
                        toReturn.add(getDataBy(it))
                    }
            }
        scope2
            .launch {
                (11..20)
                    .forEach {
                        toReturn.add(getDataBy(it))
                    }
            }
        return toReturn
    }

    private suspend fun getDataBy(arg: Int): Int {
        delay(300)
        return arg + Random.nextInt(30)
    }
}

fun main() {
    val getter = SomeDataGetter()
    val data = getter.getAllData()
    println("Data size ${data.size}")
    data.forEach {
        println(it)
    }
}