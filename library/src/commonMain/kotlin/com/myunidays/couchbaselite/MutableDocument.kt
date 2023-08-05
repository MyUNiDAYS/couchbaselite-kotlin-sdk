package com.myunidays.couchbaselite

expect class MutableDocument : Document {

    companion object {
        fun setJSON(json: String): MutableDocument
    }
}