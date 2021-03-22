package com.teraculus.remotefunctions.domain.core

import com.squareup.duktape.Duktape

class CoreRepository : CoreRepositoryInterface {

    override fun executeFunction(function: String): Any {

        var processJS = Duktape.create()
        var result = processJS.evaluate(function)
        processJS.close()

        return result
    }

}