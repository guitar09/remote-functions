package com.teraculus.remotefunctions.domain.core

interface CoreRepositoryInterface {

    fun executeFunction(function : String) : Any

}