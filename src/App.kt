fun main(args: Array<String>) {

    // Input
    print("Grid dimensions:")
    val (width, height) = readLine()!!.split(' ')

    print("Initial position:")
    val (x, y, direction) = readLine()!!.split(' ')

    print("Commands:")
    val commands = readLine()!!

    val grid = Grid(
        width.toInt(), height.toInt()
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
    println(grid.current.toString())
}