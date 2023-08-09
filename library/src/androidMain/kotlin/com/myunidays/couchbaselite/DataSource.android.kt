package com.myunidays.couchbaselite

actual class DataSource internal constructor(val android: com.couchbase.lite.DataSource) {
    actual companion object {
        actual fun database(database: Database): DataSource =
            DataSource(com.couchbase.lite.DataSource.database(database.android))

        actual fun collection(collection: Collection): DataSource =
            DataSource(com.couchbase.lite.DataSource.collection(collection.android))
    }
}
