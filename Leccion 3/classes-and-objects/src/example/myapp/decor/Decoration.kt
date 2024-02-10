package example.myapp.decor

data class Decoration(val rocks: String) {

}

data class Decoration2(val rocks: String, val wood: String, val dive: String) {

}

fun makeDecorations(){
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))

    val d5 = Decoration2("crystal", "wood", "diver")

    println(d5)

    // Assign all properties to variables.
    val (rock, wood, diver) = d5

    println(rock)
    println(wood)
    println(diver)


}

//enum class Color(val rgb: Int){
//    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
//}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name: String) = println("My favorite $name")
    }
}

class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

fun main(){
    makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")

    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    var numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}\n")
    println("${equipment2.first.second}")

    val (tool, use) = equipment
    println("$tool is used for $use")

    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")

    val list = listOf(1, 5, 3, 4)
    println(list.sum())

    val list2 = listOf("a", "bbb", "cc")
    //println(list2.sum()) // ⇒ error: none of the following functions can be called with the arguments supplied:
    println(list2.sumBy { it.length })

    for (s in list2.listIterator()) {
        println("$s ")
    }

    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )

    println (scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    println(scientific.getOrElse("swordtail") {"sorry, I don't know"})

}