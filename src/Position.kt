data class Position(
    val x: Int,
    val y: Int,
    val direction: Char
) {
    override fun toString(): String = "$x $y $direction"
}