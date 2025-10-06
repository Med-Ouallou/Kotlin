package com.solicodet.bonnes_pratiques.demo

class Person(val name: String, val age: Int) {
    fun isAdult(): Boolean {
        return age >= 18
    }
}

fun main() {
    val p1 = Person("Mohamed", 20)
    println("${p1.name} is adult? ${p1.isAdult()}")  // true
}