package com.myunidays.couchbaselite

expect class MutableDocument : Document {
    fun setJSON(json: String)
    fun setBoolean(key: String, value: Boolean)
    fun setDouble(key: String, value: Double)
    fun setFloat(key: String, value: Float)
    fun setInt(key: String, value: Int)
    fun setString(key: String, value: String)

    companion object {
        fun setJSON(json: String): MutableDocument
    }
}
