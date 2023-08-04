package com.myunidays.couchbaselite

expect class MutableDocument {

    companion object {
        fun setJSON(json: String): MutableDocument
    }
}