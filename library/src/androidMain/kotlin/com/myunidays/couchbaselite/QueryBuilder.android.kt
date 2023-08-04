package com.myunidays.couchbaselite

import com.couchbase.lite.DataSource
import com.couchbase.lite.SelectResult

actual object QueryBuilder {

    actual fun select(database: Database) : Query = Query(
        com.couchbase.lite.QueryBuilder
            .select(SelectResult.all())
            .from(DataSource.database(database.android))
    )

    actual fun createQuery(
        query: String,
        database: Database
    ): Query = Query(com.couchbase.lite.QueryBuilder.createQuery(query, database.android))

    actual fun select(collection: Collection): Query = Query(
        com.couchbase.lite.QueryBuilder
            .select(SelectResult.all())
            .from(DataSource.collection(collection.android))
    )
}