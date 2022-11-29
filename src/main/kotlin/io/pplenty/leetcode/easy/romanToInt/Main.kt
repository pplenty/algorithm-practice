package io.pplenty.leetcode.easy.romanToInt

fun romanToInt(s: String): Int {
    var result = 0

    for (i in 0..s.length - 2) {
        if (SYMBOL_MAP[s[i]]!! >= SYMBOL_MAP[s[i + 1]]!!) {
            result += SYMBOL_MAP[s[i]]!!
        } else {
            result -= SYMBOL_MAP[s[i]]!!
        }
    }

    return result + SYMBOL_MAP[s.last()]!!
}

private val SYMBOL_MAP = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
)

fun main(args: Array<String>) {
    println(romanToInt("MIXIV")) // 1013
}