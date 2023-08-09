package com.myunidays.couchbaselite

@Suppress("UtilityClassWithPublicConstructor")
expect open class SelectResult {
    companion object {
        fun all(): SelectResult
        fun expression(expression: Expression): SelectResult
        fun property(property: String): SelectResult
    }
}
