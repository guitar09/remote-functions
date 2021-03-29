package com.teraculus.remotefunctions.domain.core

import com.teraculus.remotefunctions.domain.Constants
import com.teraculus.remotefunctions.domain.model.*
import java.util.HashMap
import java.util.regex.Pattern


class CoreFunction(coreRepository: CoreRepositoryInterface) : CoreFunctionInterface(coreRepository) {

     override fun searchParamsFunction(function: String): List<Param> {

        var mapParams = ArrayList<Param>()

        val matcher = Pattern.compile(Regex("\\[(.*?)\\]").toString()).matcher(function)
        while (matcher.find()) {
            mapParams.add(Param(matcher.group()))
        }

        return mapParams
    }

    override fun replaceAllParam(function: String, params: HashMap<Param, ParamSet>, replaceAllParams : Boolean): String {


        val foundParams = searchParamsFunction(function)

        var functionAll = function

        for (key in foundParams) {
            try {
                functionAll = functionAll.replace(key.param, (params.get(key) as ParamSet).param)

            } catch (error: Exception) {
                if(replaceAllParams) throw CoreException(Constants.messageNotFoundParamsExeception + " ${key.param}")
            }
        }

        return functionAll
    }

     override fun getFunction(core : CoreModel): String {
        return replaceAllParam(core.function.replace(getReplaceFunctionName(), core.functionName), core.params, core.forceReplaceAllParams)
    }

    override fun getReplaceFunctionName(): String = "#FUNCTION_NAME#"

}