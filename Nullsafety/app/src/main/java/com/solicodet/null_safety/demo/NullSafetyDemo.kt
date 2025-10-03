package com.solicodet.null_safety.demo

fun greet(input: String?): String =
    input?.trim()?.takeIf { it.isNotEmpty() }?.let { "Bonjour, $it !" } ?: ""
    //---|------------|-------------------------|------------------------|----
    //___1____________2_________________________3________________________4____

    // 1 : ila makantch input null dirla trim()
    // 2 : nas makhasoch ykon khawi
    // 3 : ida makanch nas null  wmakanch khawi ratraja3 Bonjour ...

fun parseCount(input: String?): Int =
    input
        ?.trim()
        ?.toIntOrNull()
        ?.coerceAtLeast(0)
        ?: 0

fun safeAt(xs: List<Int>, index: Int): Int =
    xs.getOrNull(index) ?: -1

fun parseAnyToNonNegativeInt(x: Any?): Int =
    (x as? String)?.toIntOrNull()?.coerceAtLeast(0) ?: 0

fun pipeline(name: String?, countText: String?): String =
    "${greet(name)}#${parseCount(countText)}"


fun lengthOrZero(s: String?): Int = s?.length ?: 0

fun nonNullOrFail(s: String?): String =
    requireNotNull(s) { "Valeur requise non fournie" }


fun main() {
    println("======== DEMO Null-safety ========")
    println(greet(null))        // ""
    println(greet("  "))        // ""
    println(greet("  Ada "))    // "Bonjour, Ada !"
    println("==================================")
    println(greet("  Ada "))    // "Bonjour, Ada !"
    println(parseCount(null))   // 0
    println(parseCount(" -5 ")) // 0   (trim -> "-5" -> toIntOrNull -> -5 -> coerceAtLeast(0) -> 0)
    println(parseCount(" 12 ")) // 12  (trim -> "12" -> toIntOrNull -> 12 -> coerceAtLeast(0) -> 12)
    println("==================================")
    println(greet("  Ada "))
    println(parseCount(" 12 "))
    println(safeAt(listOf(10, 20), 1))  // 20
    println(safeAt(listOf(10, 20), 9))  // -1
    println("==================================")
    println(greet("  Ada "))
    println(parseCount(" 12 "))
    println(safeAt(listOf(10, 20), 1))
    println(parseAnyToNonNegativeInt("42"))   // 42
    println(parseAnyToNonNegativeInt("x"))    // 0
    println(parseAnyToNonNegativeInt(null))   // 0
    println(pipeline(" Ada ", " 12 "))        // "Bonjour, Ada !#12"
    println("==================================")
    println(lengthOrZero(null))     // 0
    println(lengthOrZero("Kotlin")) // 6
    // Exemple positif (évite un crash intentionnel) :
    println(nonNullOrFail("OK"))    // "OK"
}
