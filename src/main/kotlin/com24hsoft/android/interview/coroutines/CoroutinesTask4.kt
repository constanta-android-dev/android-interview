package com24hsoft.android.interview.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Внести изменения в функцию getEntitiesDetailsByIds таким образом, чтобы она выполнилась быстрее,
 * но сохранила порядок
 */
class EntityRepository {

    suspend fun getEntitiesDetailsByIds(ids: List<String>): List<EntityDetails> {
        val details = mutableListOf<EntityDetails>()
        ids.forEach {
            val entityDetails = getEntityDetails(it)
            details.add(entityDetails)
        }
        return details
    }


    private suspend fun getEntityDetails(id: String): EntityDetails {
        delay(1_000)
        return EntityDetails(id)
    }
}

data class EntityDetails(val id: String)

fun main() {
    val ids = (0..10).map { it.toString() }
    val repository = EntityRepository()
    runBlocking {
        val startTime = System.currentTimeMillis()
        val entitiesDetails = repository.getEntitiesDetailsByIds(ids)
        val period = System.currentTimeMillis() - startTime
        println("Total time: $period ms")
    }
}