class Grid(private val upperX: Int, private val upperY: Int) {

    private val moves = mutableListOf<Position>()

    private val dropOffPoints = mutableListOf<Position>()

    val current: Position?
        get() = moves.last()

    val dropOffPosition: Position?
        get() = if (moves.last() == LOST) moves[moves.lastIndex - 1] else null

    fun setRobotPosition(position: Position): Boolean =
        if (dropOffPoints.contains(position)) {
            false
        } else if (position.x in (0..upperX) && position.y in (0..upperY)) {
            moves.add(position)
            false
        } else {
            dropOffPoints.add(position)
            moves.add(LOST)
            true
        }

    companion object {
        val LOST = Position(-1, -1, 'X')
    }
}