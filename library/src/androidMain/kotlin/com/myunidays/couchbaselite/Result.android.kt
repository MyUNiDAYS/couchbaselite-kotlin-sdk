package com.myunidays.couchbaselite

actual class Result internal constructor(private val android: com.couchbase.lite.Result) {
    actual val keys: List<String>
        get() = android.keys
    actual fun toJSON(): String = android.toJSON()
    actual fun getDictionary(index: Int): Dictionary? = android.getDictionary(index)?.let { Dictionary(it) }
}
