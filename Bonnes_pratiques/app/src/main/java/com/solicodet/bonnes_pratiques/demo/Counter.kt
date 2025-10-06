package com.solicodet.bonnes_pratiques.demo

data class Counter(val value: Int = 0) {
    fun increment(): Counter {
        return copy(value = value + 1)
    }
}

fun main() {
    var c = Counter()
    c = c.increment()
    println(c.value) // 1
}