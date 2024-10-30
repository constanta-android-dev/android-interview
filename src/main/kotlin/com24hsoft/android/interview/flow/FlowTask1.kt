import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

suspend fun get1(value: Int): Double {
    delay(1)
    return value * 6.66
}

fun get2(value: Int): Double {
    return value * 77.7
}

fun main() = runBlocking {
    val stream = flowOf(1, 2, 2, 2, 3, 4, 4, 5, 4, 5, 5, 6, 6, 7, 8, 9)
    // если очередной элемент равен предыдущему, то нужно найти для него значение из get1
    // если они разные, то из get2
    // вывести первые 4 элемента, значение которых больше 30
    // если таких элементов меньше 4ёх, то выдать ошибку
}
