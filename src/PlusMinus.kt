import kotlin.Throws
import java.io.IOException
import kotlin.jvm.JvmStatic
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Stream

internal object Result {
    fun plusMinus(arr: List<Int>) {
        var p = 0
        var n = 0
        var z = 0
        for (i in arr.indices) {
            if (arr[i] < 0) {
                p++
            }
            if (arr[i] > 0) {
                n++
            }
            if (arr[i] == 0) {
                z++
            }
        }
        println(p / arr.size.toDouble())
        println(n / arr.size.toDouble())
        println(z / arr.size.toDouble())
    }
}

internal object Solution {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val n = bufferedReader.readLine().trim { it <= ' ' }.toInt()
        val arr =
            Stream.of(*bufferedReader.readLine().replace("\\s+$".toRegex(), "").split(" ".toRegex()).toTypedArray())
                .map { s: String -> s.toInt() }.toList()
        Result.plusMinus(arr)
        bufferedReader.close()
    }
}