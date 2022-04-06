import java.util.*
import kotlin.jvm.JvmStatic

object MinMaxSum {
    private val scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = IntArray(5)
        val arrItems = scanner.nextLine().split(" ".toRegex()).toTypedArray()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0..4) {
            val arrItem = arrItems[i].toInt()
            arr[i] = arrItem
        }
        minMaxSum(arr)
        scanner.close()
    }

    fun minMaxSum(arr: IntArray) {
        var resultMax: Long = 0
        var resultMin: Long = 0
        var temp: Long = 0
        val arrLength = arr.size
        for (i in 0 until arrLength) {
            for (j in 0 until arrLength) {
                if (j != i) {
                    temp = arr[j] + temp
                }
            }
            if (resultMax == 0L) {
                resultMax = temp
                resultMin = temp
            } else if (temp > resultMax) {
                resultMax = temp
            } else if (temp < resultMin) {
                resultMin = temp
            }
            temp = 0
        }
        println("$resultMin $resultMax")
    }
}