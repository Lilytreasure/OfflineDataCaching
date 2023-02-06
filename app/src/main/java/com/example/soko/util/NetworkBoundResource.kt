package com.example.soko.util

import kotlinx.coroutines.flow.*


inline fun <ResultType, RequestType >networkBoundResource(
    //getting data from the database
    //Flow  will keep emitting data
    crossinline query:()-> Flow<ResultType>,
    crossinline fetch: suspend ()-> RequestType,
    // Saving data to SQl Lite database
    crossinline  saveFetchResult:suspend (RequestType) ->Unit,
    crossinline shouldFetch: (ResultType) -> Boolean ={true}

)= flow{
    val data= query().first()

    val flow=if (shouldFetch(data)){
        emit(Resource.Loading(data))
        //an error may occur during fetch such as no internet connection
        // The exception is handled to prevent the app from crashing
        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        }catch (throwable: Throwable){

            query().map { Resource.Error(throwable,it) }
        }

    }else{
        query().map { Resource.Success(it) }
    }

    emitAll(flow)

}