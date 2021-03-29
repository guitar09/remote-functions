package com.teraculus.remotefunctions.domain.model

interface BaseType


data class IntFunc(private val result: Int) : BaseType, Type<Int> {
    override fun toResult(): Int {
        return result
    }


}

data class DoubleFunc(private val result: Double) : BaseType, Type<Double> {
    override fun toResult(): Double {
        return result
    }
}

data class StringFunc(private val result: String) : BaseType, Type<String> {


    override fun toResult(): String {
        return result
    }
}

data class BooleanFunc(private val result: Boolean) : BaseType, Type<Boolean> {


    override fun toResult(): Boolean {
        return result
    }
}