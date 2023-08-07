package com.myunidays.couchbaselite

expect class ResultSet {
    fun allResults(): List<Result>
    fun next(): Result?
}
