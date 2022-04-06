import kotlin.Throws
import java.io.IOException
import kotlin.jvm.JvmStatic
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*

object TimeConversion {
    fun timeConversion(s: String): String {
        val a = s.split(":".toRegex()).toTypedArray()
        val r: String
        r = if (a[2][2] == 'P') {
            if (a[0] == "12") {
                "12" + ":" + a[1] + ":" + a[2][0] + a[2][1]
            } else {
                (a[0].toInt() + 12).toString() + ":" + a[1] + ":" + a[2][0] + a[2][1]
            }
        } else if (a[0] == "12" && a[2][2] == 'A') {
            "00" + ":" + a[1] + ":" + a[2][0] + a[2][1]
        } else {
            a[0] + ":" + a[1] + ":" + a[2][0] + a[2][1]
        }
        return r
    }

    private val scan = Scanner(System.`in`)
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bw = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
        val s = scan.nextLine()
        val result = timeConversion(s)
        bw.write(result)
        bw.newLine()
        bw.close()
    }
}