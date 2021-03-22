package com.teraculus.remotefunctions.domain.controller

import com.teraculus.remotefunction.domain.Constants
import com.teraculus.remotefunction.domain.core.CoreFunctionInterface
import com.teraculus.remotefunction.domain.core.CoreModel
import com.teraculus.remotefunctions.domain.model.BaseType
import com.teraculus.remotefunctions.domain.core.CoreFunction
import com.teraculus.remotefunctions.domain.core.CoreRepository
import com.teraculus.remotefunctions.domain.core.CoreRepositoryInterface
import com.teraculus.remotefunctions.domain.model.BuildParam
import com.teraculus.remotefunctions.domain.model.Param
import com.teraculus.remotefunctions.domain.model.ParamSet


class ControllerFunction(val function: String) : ControllerFunctionInterface() {


    protected var paramList : HashMap<Param, ParamSet> = HashMap()
    protected var nameFunction: String = Constants.emptyString
    protected var forceReplaceAllParams: Boolean = false

    fun addParam(param: String, paramSet: String) = apply { this.paramList.put(Param(BuildParam.build(param)), ParamSet(paramSet))}
    fun nameFunction(nameFunction: String) = apply { this.nameFunction = nameFunction }
    fun forceReplaceAllParams(replaceAllParams: Boolean) = apply { this.forceReplaceAllParams = replaceAllParams }
    inline fun <reified T : BaseType> build() = getResult<T>(CoreModel(function, paramList, nameFunction, forceReplaceAllParams))




    override fun getRepository() : CoreRepositoryInterface {
        return CoreRepository()
    }

    override fun getCoreFunction(): CoreFunctionInterface {
        return CoreFunction(getRepository())
    }


    override fun printFunction() = getCoreFunction().getFunction(CoreModel(function, paramList, nameFunction, forceReplaceAllParams))

}

