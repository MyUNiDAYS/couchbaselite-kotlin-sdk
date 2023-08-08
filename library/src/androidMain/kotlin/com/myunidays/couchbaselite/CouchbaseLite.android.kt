package com.myunidays.couchbaselite

import android.content.Context
import com.couchbase.lite.CouchbaseLite
import com.couchbase.lite.Database
import com.couchbase.lite.LogDomain

actual object CouchbaseLite {
    actual fun init(context: Any?, logLevel: LogLevel) {
        CouchbaseLite.init(context as Context)
        Database.log.console.domains = LogDomain.ALL_DOMAINS
        Database.log.console.level = logLevel.toNative()
    }
}