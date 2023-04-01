package com.paulohenrique.codelabsinheritance
import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    fun printProprieties(dwelling: Dwelling) {
        with(dwelling){
            println("\n${nameConstruction}\n===============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Floor area: %.2f".format(floorArea()))
            if (dwelling is RoundHut) {
                println("Carpet Length: %.2f".format(calculateMaxCarpetLength()))
            }
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
    abstract fun calculateMaxCarpetLength(): Double

    fun getRoom() {
        if (hasRoom()) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val nameConstruction = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }

    override fun calculateMaxCarpetLength(): Double {
        TODO("Not yet implemented")
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val nameConstruction = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
    override fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
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
