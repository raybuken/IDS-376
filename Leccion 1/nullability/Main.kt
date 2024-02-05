fun main(){
    var marbles: Int? = null

    var fishFoodTreats = 6
//    if (fishFoodTreats != null) {
//        fishFoodTreats = fishFoodTreats.dec()
//    }

    fishFoodTreats = fishFoodTreats?.dec() ?: 0

    println(fishFoodTreats)

}