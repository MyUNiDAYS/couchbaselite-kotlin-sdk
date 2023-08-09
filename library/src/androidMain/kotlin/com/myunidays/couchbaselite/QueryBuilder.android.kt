package com.myunidays.couchbaselite

actual object QueryBuilder {
    fun createQuery(
        query: String,
        database: Database
    ): Query = Query(com.couchbase.lite.QueryBuilder.createQuery(query, database.android))
    actual fun selectDistinct(selectResult: SelectResult, dataSource: DataSource) = Query(
        com.couchbase.lite.QueryBuilder
            .selectDistinct(selectResult.android)
            .from(dataSource.android)
    )
    actual fun select(
        vararg selectResults: SelectResult,
        dataSource: DataSource,
        expression: Expression
    ): Query {
        val query = com.couchbase.lite.QueryBuilder
            .select(*selectResults.map { it.android }.toTypedArray())
            .from(dataSource.android)
        expression?.let {
            query.where(expression.android)
        }
        return Query(query)
    }

    actual fun select(
        vararg selectResults: SelectResult,
        dataSource: DataSource
    ): Query = Query(
        com.couchbase.lite.QueryBuilder
            .select(*selectResults.map { it.android }.toTypedArray())
            .from(dataSource.android)
    )
}
