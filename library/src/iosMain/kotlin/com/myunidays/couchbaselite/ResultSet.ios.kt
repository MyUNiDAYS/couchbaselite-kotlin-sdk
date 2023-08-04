package com.myunidays.couchbaselite


actual class ResultSet internal constructor(
    private val ios: cocoapods.CouchbaseLite.CBLQueryResultSet
) {
    actual fun allResults(): List<Result> =
        ios.allResults()
            ?.map { Result(it as cocoapods.CouchbaseLite.CBLQueryResult) }
            ?: emptyList()
}
