fun main(){
    val age = 22
    val adultAge = 18

    if(age >= adultAge){
        println("Eres mayor de edad")
    }else{
        println("Eres menor de edad")
    }

    if(age in 18..120){
        println("Estas en el rango de edad de adulto")
    }

    if(age == 0){
        println("recien nacido")
    } else if(age < 50){
        println("Aun no llegas a edad anciana")
    } else{
        println("eres un anciano")
    }


    when (age) {
        18 -> println("Mayor de edad")
        in 19..50 -> print("Adulto")
        else -> println("Anciano")
    }


}