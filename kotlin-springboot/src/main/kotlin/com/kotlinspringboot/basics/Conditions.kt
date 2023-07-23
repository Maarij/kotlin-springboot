fun main() {
    // if-else
    // when

    var name = "Maarij"
    name = "Maar"
    val result = if (name.length == 4) {
        println("Name is four characters")
        name
    } else {
        println("Name is not four characters")
        name
    }

    println("result: $result")

    // 1 -> GOLD, 2 -> SILVER, 3 -> BRONZE
    var position = 1
    val medal =
        when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> "BRONZE"
        else -> "NO MEDAL"
    }

    println(medal)
}