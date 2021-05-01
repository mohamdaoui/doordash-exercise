package com.mohamdaoui.doordash.viewmodel

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable

class HomeBannerVM(val context: Context?) : BaseObservable() {

    var visibility: Int
        set(value) {
            visibilityValue = value
        }
        get() {
            return visibilityValue
        }

    private var visibilityValue = decideVisibility()


    val test: String
        get() {
            return "TEST"
        }

    fun onClick(view: View) {
        // I would create a singleton to manage sharedprefs
        val context = view.context
        val sharedPreferences = context.getSharedPreferences("app", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("wasDismissed", true).apply()
        visibility = View.GONE
        notifyChange()
    }

    private fun decideVisibility(): Int {
//        val context = view.context
        val sharedPreferences = context?.getSharedPreferences("app", Context.MODE_PRIVATE)
        val dismissed = sharedPreferences?.getBoolean("wasDismissed", false) ?: false
        if (dismissed) {
            return View.GONE
        } else {
            return View.VISIBLE
        }
    }


}