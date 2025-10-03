package com.solicodet.fonctions_lambdas.demo


fun operation(a: Double) = a * 9 / 5 + 32 //short hand function li katktab f star wahd

fun Salam(name: String, punctuation: String = "ktab smaitak !") =
    "Salam, ${name.trim()}$punctuation" // value and default value

fun avg(vararg numbers: Int) = numbers.average()

val square = { x: Int -> x * x }
val shout: (String) -> String = { it.uppercase() }

fun String.sanitized() = trim().replace(Regex("\\s+"), " ")

fun main(){
    //========== 1 ============
    val r1 = operation(3.3)
    println("result is : $r1")
    //========== 2 ============
    println(Salam(""))
    //========== 3 ============
    println(avg(1, 2, 3, 4))  // Attendu: 2.5
    val arr = intArrayOf(2, 4, 6)
    println(avg(*arr))        // Attendu: 4.0
    //========= 4 ======================================
    println(square(5))        // Attendu: 25
    println(shout("kotlin"))  // Attendu: KOTLIN
    //=========== 5 ====================================
    // 5) extension
    println("  Hello   Kotlin  ".sanitized()) // Hello Kotlin

}