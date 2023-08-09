package com.myunidays.couchbaselite

actual object QueryBuilder {
    actual fun selectDistinct(selectResult: SelectResult, dataSource: DataSource): Query = Query(
        cocoapods.CouchbaseLite.CBLQueryBuilder
            .selectDistinct(listOf(selectResult.ios), dataSource.ios)
    )
    actual fun select(
        vararg selectResults: SelectResult,
        dataSource: DataSource,
        expression: Expression
    ): Query = Query(
        cocoapods.CouchbaseLite.CBLQueryBuilder.select(
            select = selectResults.map { it.ios },
            from = dataSource.ios,
            where = expression?.ios
        )
    )
    actual fun select(
        vararg selectResults: SelectResult,
        dataSource: DataSource
    ): Query = Query(
        cocoapods.CouchbaseLite.CBLQueryBuilder.select(
            select = selectResults.map { it.ios },
            from = dataSource.ios
        )
    )
}
