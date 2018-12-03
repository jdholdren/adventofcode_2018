import scala.io.Source

object Main {
    def main(args: Array[String]): Unit = {
        println(secondAnswer)
    }

    def firstAnswer(): Int = {
        readInByLine("./input.txt")
            .map(x => toInt(x))
            .fold(0)(_ + _)
    }
    
    def secondAnswer(): Int = {
        val lis = readInByLine("./input.txt").map(x => toInt(x))
        stopAfterRepeat(
            lis,
            lis,
            0,
            Map[Int,Boolean]()
        )
    }

    def stopAfterRepeat(orig: List[Int], as: List[Int], acc: Int, m: Map[Int, Boolean]): Int = as match {
        case Nil    => stopAfterRepeat(orig, orig, acc, m)
        case x::xs  => m.get(acc + x) match {
            case Some(sum)  => acc + x
            case _          => stopAfterRepeat(orig, xs, acc + x, m + ((acc+x) -> true))
        }
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