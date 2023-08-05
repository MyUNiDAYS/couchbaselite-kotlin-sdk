package com.myunidays.couchbaselite

actual class Query internal constructor(private val ios: cocoapods.CouchbaseLite.CBLQuery){
    actual val parameters: Parameters?
        get() = ios.parameters
    actual fun execute(): ResultSet? = ios.execute(null)?.let { ResultSet(it) }
    actual fun explain(): String? = ios.explain(null)
}