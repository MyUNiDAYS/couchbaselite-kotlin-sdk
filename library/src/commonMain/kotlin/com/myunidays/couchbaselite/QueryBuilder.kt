package com.myunidays.couchbaselite

expect object QueryBuilder {
    fun selectDistinct(selectResult: SelectResult, dataSource: DataSource): Query
    fun select(vararg selectResults: SelectResult, dataSource: DataSource, expression: Expression): Query
    fun select(vararg selectResults: SelectResult, dataSource: DataSource): Query
}
