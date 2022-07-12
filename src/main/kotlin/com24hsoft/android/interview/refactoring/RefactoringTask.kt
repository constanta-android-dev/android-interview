package com24hsoft.android.interview.refactoring

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.File
import java.util.*

class CarsViewModel {

    val carDataProducer = CarManager.instance
    val cars = MutableStateFlow<List<Car>>(emptyList())

    init {
        val carList = carDataProducer.getCars().blockingFirst()
        cars.value = carList.filter {
            it.isDeleted == "false"
        }
    }
}

class CarManager {

    companion object {
        val instance = CarManager()
        fun create(): CarManager = instance
    }

    val repository = CarRepository()
    fun getCars(): Observable<List<Car>> = repository.cars().map {
        it.map {
            it.copy(price = repository.convertCarPrice(it.price).toInt())
        }
    }
}

class CarRepository {

    val data = File("cars.txt").readLines().map {
        Car(
            it.split(",")[0],
            it.split(",")[1],
            it.split(",")[2].toInt(),
            it.split(",")[3],
        )
    }

    fun cars(): Observable<List<Car>> {
        return Observable.just(data)
    }

    fun convertCarPrice(price: Int): Double {
        if (Locale.getDefault().language == "en") {
            return price * 86.6
        } else if (Locale.getDefault().language == "fr") {
            return price * 96.5
        } else {
            return price.toDouble()
        }
    }
}


data class Car(
    val id: String,
    val name: String,
    val price: Int,
    val isDeleted: String
)