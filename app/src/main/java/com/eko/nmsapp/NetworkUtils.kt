package com.eko.nmsapp

import java.io.BufferedReader
import java.io.InputStreamReader

object NetworkUtils {
    fun ping(host: String): Boolean {
        return try {
            val process = Runtime.getRuntime().exec("/system/bin/ping -c 1 $host")
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            reader.readLines()
            process.waitFor()
            process.exitValue() == 0
        } catch (e: Exception) {
            false
        }
    }
}