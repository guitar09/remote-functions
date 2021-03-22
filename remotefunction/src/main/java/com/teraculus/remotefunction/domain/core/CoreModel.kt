package com.teraculus.remotefunction.domain.core

import com.teraculus.remotefunction.domain.Constants
import com.teraculus.remotefunctions.domain.model.Param
import com.teraculus.remotefunctions.domain.model.ParamSet

class CoreModel(val function : String,
                val params: HashMap<Param, ParamSet>,
                val functionName : String = Constants.emptyString,
                var forceReplaceAllParams : Boolean = false)