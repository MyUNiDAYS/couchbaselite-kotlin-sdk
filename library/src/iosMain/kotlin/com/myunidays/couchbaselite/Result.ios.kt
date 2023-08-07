package com.myunidays.couchbaselite

actual class Result internal constructor(private val ios: cocoapods.CouchbaseLite.CBLQueryResult) {
    actual val keys: List<String>
        get() = ios.keys.map { it as String }
    actual fun toJSON(): String = ios.toJSON()
    actual fun getDictionary(index: Int): Dictionary? = ios.dictionaryAtIndex(index.toULong())?.let { Dictionary(it) }
}
