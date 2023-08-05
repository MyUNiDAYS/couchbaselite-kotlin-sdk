package com.myunidays.couchbaselite

import com.couchbase.lite.SelectResult

actual open class SelectResult internal constructor(val android: com.couchbase.lite.SelectResult){
    actual class From internal constructor(android: SelectResult) : com.myunidays.couchbaselite.SelectResult(android) {
    }

    actual class As internal constructor(android: SelectResult) : com.myunidays.couchbaselite.SelectResult(android) {

    }

    actual companion object {
        actual fun all(): From = From(com.couchbase.lite.SelectResult.all())
    }
}