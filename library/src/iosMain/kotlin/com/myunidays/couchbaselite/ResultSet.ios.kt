package com.myunidays.couchbaselite

import cocoapods.CouchbaseLite.CBLQueryResultSet

actual class ResultSet internal constructor(
    private val ios: cocoapods.CouchbaseLite.CBLQueryResultSet
) {
    actual fun allResults(): List<Result> =
        ios.allResults()
            ?.map { Result(it as CBLQueryResultSet) }
            ?: emptyList()
}
