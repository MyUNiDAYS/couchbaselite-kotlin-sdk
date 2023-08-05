package com.myunidays.couchbaselite

actual class Query internal constructor(private val android: com.couchbase.lite.Query){
    actual val parameters: Parameters?
        get() = android.parameters
    actual fun execute(): ResultSet? = ResultSet(android.execute())
    actual fun explain(): String? = android.explain()
}
