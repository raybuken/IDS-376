package src

import java.util.Random

fun main(args: Array<String>){
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println("Hello, ${args[0]}")

    // Will assign kotlin.Unit
    val isUnit = println("this is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if(temperature > 50) true else false
    println(isHot)
    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)

    feedTheFish()

    swim()
    swim("slow")
    swim(speed = "turtle-like")

    // eager, creates a new list
    val eager = decorations.filter {it[0] == 'p'}
    println("eager: $eager")

    var filtered = decorations.asSequence().filter{it[0] == 'p'}
    println("filtered: $filtered")

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    val waterFilter = { dirty : Int -> dirty / 2}
    println(updateDirty(30, waterFilter))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String{
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String{

    return when (day){
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) ->  true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun getDirtySensorReading(): Int{
    return 20
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}