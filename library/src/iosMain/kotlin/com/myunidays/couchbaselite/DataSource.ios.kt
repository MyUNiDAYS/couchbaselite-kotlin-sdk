package com.myunidays.couchbaselite

actual class DataSource internal constructor(val ios: cocoapods.CouchbaseLite.CBLQueryDataSource) {
    actual companion object {
        actual fun database(database: Database): DataSource =
            DataSource(cocoapods.CouchbaseLite.CBLQueryDataSource.database(database.ios))
        actual fun collection(collection: Collection): DataSource =
            DataSource(cocoapods.CouchbaseLite.CBLQueryDataSource.collection(collection.ios))
    }
}
