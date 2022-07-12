package com24hsoft.android.interview.coroutines

import kotlinx.coroutines.runBlocking

/**
 * Дописать функцию getNetworkData так, чтобы он вернул результат NetworkDataGetter::getData
 */
class NetworkDataGetter {

    fun getData(callback: Callback) {
        println("Getting network data...")
        Thread {
            Thread.sleep(1000)
            println("Got network data...")
            callback.onDataGot("Some data")
        }.start()
    }

    interface Callback {

        fun onDataGot(data: String)
    }
}

suspend fun getNetworkData(): String {
    val networkDataGetter = NetworkDataGetter()
    TODO()
}

fun main() {
    runBlocking {
        val getNetworkDataResult = getNetworkData()
        println(getNetworkDataResult)
    }
}

