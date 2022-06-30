package kt2.ch7

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 * try catch finally
 * try catch도 expression으로 간주
 *
 * Checked Exception과 UncheckedException
 * 코틀린에서는 모두 UncheckedException이다.
 *
 * try with resources가 코틀린에서 없다.
 * 대신 코틀린의 언어적 특징을 활용해 close를 호출해준다.
 *
 *
 *
 * */

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    } finally {

    }
}

fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}


fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

fun readFile2(path: String?) {
    BufferedReader(FileReader(path))
        .use { reader -> println(reader.readLine()) }
}