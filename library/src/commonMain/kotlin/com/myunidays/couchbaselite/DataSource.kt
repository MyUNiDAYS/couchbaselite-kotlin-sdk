package com.myunidays.couchbaselite

@Suppress("UtilityClassWithPublicConstructor")
expect class DataSource {
    companion object {
        fun database(database: Database): DataSource
        fun collection(collection: Collection): DataSource
    }
}
