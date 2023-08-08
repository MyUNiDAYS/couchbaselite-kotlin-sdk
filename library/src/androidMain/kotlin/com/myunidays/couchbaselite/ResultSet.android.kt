package com.myunidays.couchbaselite

actual class ResultSet internal constructor(
    private val android: com.couchbase.lite.ResultSet
) {
    actual fun allResults(): List<Result> =
        android.allResults().map { Result(it) }
    actual fun next(): Result? = android.next()?.let { Result(it) }
}
