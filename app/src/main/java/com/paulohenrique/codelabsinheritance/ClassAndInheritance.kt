package com.paulohenrique.codelabsinheritance
import kotlin.math.PI

fun main() {
    fun printProprieties(dwelling: Dwelling) {
        with(dwelling){
            println("\n${nameConstruction}\n===============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            println("Floor area: %.2f".format(floorArea()))
        }
    }
    val squareCabin = SquareCabin(6, 50.0)
    printProprieties(squareCabin)
    val roundHut = RoundHut(3, 10.0)
    printProprieties(roundHut)
    val roundTower = RoundTower(4, 15.5)
    printProprieties(roundTower)
}

abstract class Dwelling(private var residents: Int) {
    abstract val nameConstruction: String
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
    abstract fun floorArea(): Double
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val nameConstruction = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val nameConstruction = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2) : RoundHut(residents, radius) {
    override val nameConstruction = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
