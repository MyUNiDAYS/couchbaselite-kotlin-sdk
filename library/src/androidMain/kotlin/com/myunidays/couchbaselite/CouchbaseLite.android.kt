package com.myunidays.couchbaselite

import android.content.Context
import com.couchbase.lite.CouchbaseLite

actual object CouchbaseLite {
    actual fun init(context: Any?) {
        CouchbaseLite.init(context as Context)
    }
}