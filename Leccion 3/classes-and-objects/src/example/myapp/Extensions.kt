package example.myapp

//fun String.hasSpaces() = indexOf(" ") != -1

open class AquariumPlant(val color: String, private val size: Int)

//fun AquariumPlant.isRed() = color == "red"    // OK
//fun AquariumPlant.isBig() = size > 50         // gives error

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "green"


fun main(){
    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?

    //nullable receivers
//    fun AquariumPlant?.pull() {
//        this?.apply {
//            println("removing $this")
//        }
//    }
//
//    val plant: AquariumPlant? = null
//    plant.pull()
}

