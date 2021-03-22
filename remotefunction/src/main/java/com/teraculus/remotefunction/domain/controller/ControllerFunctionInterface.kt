package com.teraculus.remotefunctions.domain.controller

import com.teraculus.remotefunction.domain.core.CoreFunctionInterface
import com.teraculus.remotefunction.domain.core.CoreModel
import com.teraculus.remotefunctions.domain.model.BaseType
import com.teraculus.remotefunctions.domain.core.CoreRepositoryInterface

abstract class ControllerFunctionInterface {

    protected abstract fun getCoreFunction ( ): CoreFunctionInterface
    protected abstract fun getRepository() : CoreRepositoryInterface
    abstract fun printFunction() : String

     inline fun < reified T : BaseType> getResult(core : CoreModel): T {
        var result = getCoreFunction().getResult<T>(core)

        return result
    }
}