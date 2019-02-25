fun main(args: Array<String>) {

    // Input
    print("Grid upper coordinates:")
    val (upperX, upperY) = readLine()!!.split(' ')

    print("Initial position:")
    val (x, y, direction) = readLine()!!.split(' ')

    print("Commands:")
    val commands = readLine()!!

    val grid = Grid(
        upperX.toInt(), upperY.toInt()
    )
    val initialPosition = Position(
        x.toInt(),
        y.toInt(),
        direction.first()
    )

    // Run
    val processor = Processor(grid, initialPosition, commands.toList())
    processor.execute()


    // Output
    val lastSeenPosition = grid.current
    if (lastSeenPosition != Grid.LOST) {
        println(grid.current)
    } else {
        println("${grid.dropOffPosition} LOST" )
    }
}