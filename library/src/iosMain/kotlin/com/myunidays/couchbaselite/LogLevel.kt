package com.myunidays.couchbaselite

fun LogLevel.toNative(): cocoapods.CouchbaseLite.CBLLogLevel = when (this) {
    LogLevel.DEBUG -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelDebug
    LogLevel.VERBOSE -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelVerbose
    LogLevel.INFO -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelInfo
    LogLevel.WARNING -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelWarning
    LogLevel.ERROR -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelError
    LogLevel.NONE -> cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelNone
}