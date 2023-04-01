package com.paulohenrique.codelabsinheritance

fun main() {
    fun printProprieties(dwelling: Dwelling) {
        with(dwelling){
            println("\n${nameConstruction}\n===============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
        }
    }
    val squareCabin = SquareCabin(6)
    printProprieties(squareCabin)
    val roundHut = RoundHut(3)
    printProprieties(roundHut)
    val roundTower = RoundTower(4)
    printProprieties(roundTower)
}

abstract class Dwelling(private var residents: Int) {
    abstract val nameConstruction: String
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val nameConstruction = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6
}

open class RoundHut(residents: Int) : Dwelling(residents) {
    override val nameConstruction = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

class RoundTower(residents: Int,
                 val floors: Int = 2) : RoundHut(residents) {
    override val nameConstruction = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
}
