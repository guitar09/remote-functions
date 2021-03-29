package com.teraculus.remotefunctions.domain.model

interface Type<T> {
    fun toResult(): T
}