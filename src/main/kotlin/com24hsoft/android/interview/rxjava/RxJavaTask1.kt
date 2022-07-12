import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun getValue1(value: Int): Single<Double> {
    return Single.fromCallable {
        value * 6.66
    }
}

fun getValue2(value: Int): Double {
    return value * 77.7
}

fun main() {
    val stream = Observable.fromArray(1, 2, 2, 2, 3, 4, 4, 5, 4, 5, 5, 6, 6, 7, 8, 9)
    // если очередной элемент равен предыдущему, то нужно найти для него значение из getValue1
    // если они разные, то из getValue2
    // вывести первые 4 элемента, значение которых больше 30
    // если таких элементов меньше 4ёх, то выдать ошибку
}
