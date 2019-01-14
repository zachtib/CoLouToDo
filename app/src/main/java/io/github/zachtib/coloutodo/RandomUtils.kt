package io.github.zachtib.coloutodo

import kotlin.random.Random

fun <T> List<T>.atRandom(): T {
    val index = Random.nextInt(size)
    return this[index]
}