package com.myunidays.couchbaselite

actual class Result internal constructor(private val ios: cocoapods.CouchbaseLite.CBLQueryResultSet) {
    actual fun toJSON(): String = ios.toString()
}
