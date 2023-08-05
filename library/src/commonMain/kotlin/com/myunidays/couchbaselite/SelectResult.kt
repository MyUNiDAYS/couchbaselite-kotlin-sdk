package com.myunidays.couchbaselite

expect open class SelectResult {
    companion object {
        fun all(): From
    }

    class From: SelectResult {
    }
    class As: SelectResult {

    }
}