package com.mohamdaoui.doordash.network

import java.lang.Exception

interface TaskResultHandler<Result> {
    fun onTaskSuccess(result: Result?)
    fun onTaskFailed(e: Exception) // Ideally we'd have a custom exception class depending on the API exception responses
}