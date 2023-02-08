package com.my.test.common

import java.util.*

object StringUtils {
    fun toTitleCase(string: String?): String {
        string?.let {
            val strings = string.split(" ")

            val capitalizedWords = strings.map {
                it.lowercase().replaceFirstChar { char ->
                    if (char.isLowerCase())
                        char.titlecase(Locale.getDefault())
                    else
                        char.toString()
                }
            }

            return capitalizedWords.joinToString(separator = " ")
        }
        return ""
    }
}