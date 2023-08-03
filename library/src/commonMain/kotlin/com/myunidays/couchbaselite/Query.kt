package com.myunidays.couchbaselite

expect class Query {
    fun execute(): ResultSet?
}