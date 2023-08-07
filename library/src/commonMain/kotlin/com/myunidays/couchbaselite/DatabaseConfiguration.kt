package com.myunidays.couchbaselite

expect class DatabaseConfiguration {
    var directory: String

    companion object {
        fun default(): DatabaseConfiguration
    }
}