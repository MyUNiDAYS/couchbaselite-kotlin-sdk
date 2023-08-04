package com.myunidays.couchbaselite

actual object QueryBuilder {
    actual fun select(database: Database): Query =
        Query(
            cocoapods.CouchbaseLite.CBLQueryBuilder.select(
                select = listOf(cocoapods.CouchbaseLite.CBLQuerySelectResult.all()),
                from = cocoapods.CouchbaseLite.CBLQueryDataSource.database(database.ios)
            )
        )

    actual fun createQuery(
        query: String,
        database: Database
    ): Query = TODO()
        //cocoapods.CouchbaseLite.CBLQueryBuilder().
    actual fun select(collection: Collection): Query = Query(
        cocoapods.CouchbaseLite.CBLQueryBuilder.select(
            select = listOf(cocoapods.CouchbaseLite.CBLQuerySelectResult.all()),
            from = cocoapods.CouchbaseLite.CBLQueryDataSource.collection(collection.ios)
        )
    )
}