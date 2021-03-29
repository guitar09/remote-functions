package com.teraculus.remotefunctions.domain

class Constants {
    companion object {
        val emptyString: String = ""
        val messageNotFoundParamsExeception: String = "Existem parametros que não foram preenchidos"
        val messageRuntimeFunctionException: String = "Não foi possível executar a função: Isso pode acontecer quando o tipo do retorno não foi o esperado ou a função Java Script não está correta"
    }
}