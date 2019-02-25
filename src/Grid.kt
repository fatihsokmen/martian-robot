class Grid(private val width: Int, private val height: Int) {

    private val moves = mutableListOf<Position>()

    val current: Position?
        get() = moves.last()

    fun setRobotPosition(position: Position): Boolean =
        if (position.x in (0 until width) && position.y in (1 until height)) {
            moves.add(position)
            true
        } else {
            moves.add(LOST)
            false
        }

    companion object {
        val LOST = Position(-1, -1, 'X')
    }
}