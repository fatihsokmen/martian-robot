fun main(args: Array<String>) {

    // Input
    print("Grid upper coordinates:")
    val (upperX, upperY) = readLine()!!.split(' ')

    val robots = mutableListOf<Robot>()

    var numberOfRobots = 1
    do {
        print("Initial position of Robot #$numberOfRobots:")
        val position = readLine()

        if (position.isNullOrEmpty()) {
            break
        }

        val (x, y, direction) = position.split(' ')

        print("Commands of Robot #$numberOfRobots:")

        val initialPosition = Position(
            x.toInt(),
            y.toInt(),
            direction.first()
        )

        val robot = Robot(initialPosition, readLine()!!.toList())

        robots.add(robot)

        numberOfRobots++

    } while (true)


    val grid = Grid(
        upperX.toInt(), upperY.toInt()
    )

    // Run
    val processor = Processor(grid)
    robots.forEach { robot ->
        processor.execute(robot)

        // Output
        val lastSeenPosition = grid.lastSeenPosition
        if (lastSeenPosition != Grid.LOST) {
            println(grid.lastSeenPosition)
        } else {
            println("${grid.dropOffPosition} LOST")
        }

    }
}