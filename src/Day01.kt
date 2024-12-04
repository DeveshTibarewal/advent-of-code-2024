import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toInt()
            val second = line.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        return left.sorted().zip(right.sorted()).sumOf { (first, second) -> abs(first - second) }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toInt()
            val second = line.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        val rightMap = right.groupingBy { it }.eachCount()

        return left.sorted().sumOf { number ->
            number * (rightMap[number] ?: 0)
        }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")

    // Calculate the result
    val result = part2(input)
    println(result)
}
