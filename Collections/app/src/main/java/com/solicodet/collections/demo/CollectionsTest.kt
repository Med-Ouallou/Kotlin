package com.solicodet.collections.demo

// === Résumé Kotlin Collections ===
// Auteur: Mohamed Ouallou 💻

data class Todo(val id: Long, val title: String, val done: Boolean)

fun main() {
    // -------------------------
    // 🟦 1. Liste de données
    // -------------------------
    val todos = listOf(
        Todo(1, "Étudier Kotlin", true),
        Todo(2, "Écrire UI Compose", false),
        Todo(3, "Tests", true),
        Todo(4, "Étudier Kotlin", false)
    )

    // -------------------------
    // 🟩 2. Filtrer + map (afficher titres finis)
    // -------------------------
    val doneTitles = todos
        .filter { it.done }   // garder ceux done=true
        .map { it.title }     // prendre juste le titre
    println("✅ doneTitles = $doneTitles")

    // -------------------------
    // 🟨 3. Compter, sommer, faire moyenne
    // -------------------------
    val totalDone = todos.count { it.done }               // nb de tâches faites
    val totalChars = todos.sumOf { it.title.length }      // somme des lettres
    val avgTitle = todos.map { it.title.length }.average() // moyenne
    println("📊 done=$totalDone, chars=$totalChars, avg=$avgTitle")

    // -------------------------
    // 🟧 4. Trier et enlever doublons
    // -------------------------
    val sorted = todos.sortedBy { it.title.lowercase() }     // tri par titre
    val distinctByTitle = todos.distinctBy { it.title }      // titres uniques
    println("🔤 sorted = ${sorted.map { it.title }}")
    println("✨ distinctByTitle = ${distinctByTitle.map { it.title }}")

    // -------------------------
    // 🟪 5. Grouper et associer
    // -------------------------
    val byDone = todos.groupBy { it.done }    // groupé selon done=true/false
    val byId = todos.associateBy { it.id }    // id comme clé
    println("🧩 byDone keys = ${byDone.keys}")
    println("🗝️ byId keys = ${byId.keys}")

    // -------------------------
    // 🟫 6. Nettoyer les nulls
    // -------------------------
    val maybeIds = listOf(1, null, 2)
    val ids = maybeIds.filterNotNull()        // supprime les nulls
    println("🚿 ids = $ids")

    // -------------------------
    // 🟦 7. Créer Map personnalisée
    // -------------------------
    val kv = todos.associate { it.title to it.title.length }
    println("🗺️ kv = $kv")
}
