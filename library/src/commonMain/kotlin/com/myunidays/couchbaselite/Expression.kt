package com.myunidays.couchbaselite

expect class Expression {

    fun equalTo(expression: Expression): Expression
    @Suppress("FunctionNaming")
    fun `is`(expression: Expression): Expression
    fun isNot(expression: Expression): Expression

    @Suppress("TooManyFunctions")
    companion object {
        fun property(property: String): Expression
        fun value(value: Any?): Expression
        fun string(string: String): Expression
        fun number(number: Number): Expression
        fun all(): Expression
        fun boolean(boolean: Boolean): Expression
        fun double(double: Double): Expression
        fun int(int: Int): Expression
        fun float(float: Float): Expression
        fun not(expression: Expression): Expression
        fun negated(expression: Expression): Expression
    }
}
