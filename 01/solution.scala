import scala.io.Source

object Main {
    def main(args: Array[String]): Unit = {
        val ans = readInByLine("./input.txt")
            .map(x => toInt(x))
            .fold(0)(_ + _)
        println(ans)
    }

    // Reads the file in line by line into a string
    def readInByLine(filename: String): List[String] = {
        Source.fromFile(filename).getLines.toList
    }

    def toInt(s: String): Int = {
        if (s.startsWith("+")) {
            s.substring(1).toInt
        } else {
            0 - s.substring(1).toInt
        }
    }
}