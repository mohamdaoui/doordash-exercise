package com.mohamdaoui.doordash.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

// This is not used but I added it as an illustration of the work needed if we want to have a custom handling of errors
// and loading states easily inside the VMs, we would have to use this custom callback in the repository for all calls,
// then each caller defines an implementation of what to do with success and error states, for example, the home screen
// could hide/show a loader initially, then shows an error state if this fails.
class CustomCallback<T>(private val taskResultHandler: TaskResultHandler<T>?) : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        taskResultHandler?.onTaskFailed(Exception(t))
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            taskResultHandler?.onTaskSuccess(response.body())
        } else {
            val error = response.errorBody()
            if (error != null) {
                taskResultHandler?.onTaskFailed(Exception(error.toString()))
            } else {
                taskResultHandler?.onTaskFailed(Exception("UNKNOWN_ERROR"))
            }
        }
    }
}