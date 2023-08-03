package com.myunidays.couchbaselite

actual class Result internal constructor(private val android: com.couchbase.lite.Result) {
    actual fun toJSON(): String = android.toJSON()
}