class Processor(
    private val grid: Grid,
    private val initialPosition: Position,
    private val commands: List<Char>
) {

    fun execute() {
        var position = initialPosition.copy()

        commands.forEach { command ->
            position = when (command) {
                LEFT -> executeLeft(position)
                RIGHT -> executeRight(position)
                FORWARD -> executeForward(position)
                else -> position // Unrecognised command, so keep existing position
            }

            if (!grid.setRobotPosition(position)) {
                return@forEach
            }
        }
    }

    private fun executeLeft(current: Position): Position =
        LEFT_CMD_MAPPING[current.direction]?.let { nextDirection ->
            current.copy(direction = nextDirection)
        } ?: current


    private fun executeRight(current: Position): Position =
        RIGHT_CMD_MAPPING[current.direction]?.let { nextDirection ->
            current.copy(direction = nextDirection)
        } ?: current

    private fun executeForward(current: Position): Position =
        when (current.direction) {
            EAST -> current.copy(x = current.x + 1)
            SOUTH -> current.copy(y = current.y - 1)
            WEST -> current.copy(x = current.x - 1)
            NORTH -> current.copy(y = current.y + 1)
            else -> current
        }

    companion object {

        private const val LEFT = 'L'
        private const val RIGHT = 'R'
        private const val FORWARD = 'F'

        private const val EAST = 'E'
        private const val WEST = 'W'
        private const val SOUTH = 'S'
        private const val NORTH = 'N'

        private val LEFT_CMD_MAPPING = mapOf(EAST to NORTH, NORTH to WEST, WEST to SOUTH, SOUTH to EAST)
        private val RIGHT_CMD_MAPPING = mapOf(EAST to SOUTH, SOUTH to WEST, WEST to NORTH, NORTH to EAST)
    }

}