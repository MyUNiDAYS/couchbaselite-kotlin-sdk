package com.myunidays.couchbaselite

fun LogLevel.toNative(): com.couchbase.lite.LogLevel = when (this) {
    LogLevel.DEBUG -> com.couchbase.lite.LogLevel.DEBUG
    LogLevel.VERBOSE -> com.couchbase.lite.LogLevel.VERBOSE
    LogLevel.INFO -> com.couchbase.lite.LogLevel.INFO
    LogLevel.WARNING -> com.couchbase.lite.LogLevel.WARNING
    LogLevel.ERROR -> com.couchbase.lite.LogLevel.ERROR
    LogLevel.NONE -> com.couchbase.lite.LogLevel.NONE
}
