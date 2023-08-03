package com.myunidays.couchbaselite

expect class Database(name: String) {
    val name: String
    val path: String?
}