class Grid(private val upperX: Int, private val upperY: Int) {

    private val moves = mutableListOf<Position>()

    private val dropOffPoints = mutableListOf<Position>()

    val lastSeenPosition: Position
        get() = moves.last()

    val dropOffPosition: Position?
        get() = if (moves.last() == LOST) moves[moves.lastIndex - 1] else null

    fun setRobotPosition(position: Position): Boolean =
        if (position.x in (0..upperX) && position.y in (0..upperY)) {
            moves.add(position)
            false
        } else if (dropOffPoints.contains(lastSeenPosition)) {
            false
        } else {
            dropOffPoints.add(lastSeenPosition)
            moves.add(LOST)
            true
        }

    fun isDropOffPosition(position: Position) =
        dropOffPoints.contains(position)

    fun resetMoves() {
        moves.clear()
    }

    companion object {
        val LOST = Position(-1, -1, 'X')
    }
}