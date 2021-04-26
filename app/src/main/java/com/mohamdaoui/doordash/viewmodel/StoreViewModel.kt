package com.mohamdaoui.doordash.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.ui.activity.StoreDetailsActivity

class StoreViewModel(private var store: Store) : ViewModel() {

    val name: String
        get() {
            return store.name
        }

    val description: String
        get() {
            return formatDescription(store.description)
        }

    // We can imagine custom accessibility labels for company logos
    val logoContentDescription: String
        get() {
            return store.name
        }

    val imageUrl: String
        get() {
            return store.coverImage
        }

    val distance: String
        get() {
            return formatDistance(store.distance)
        }

    val ratings: String
        get() {
            return store.averageRating.toString() + " ★ (" + store.numberOfRatings?.toString() + ")" // Strings would need to be in strings.xml for localizations
        }

    val deliveryFee: String
        get() {
            return "Delivery fee: $" + store.deliveryFee.toString()
        }

    // I would probably use PublishSubject to send this event back to the fragment
    // and have it open the activity as I don't like VMs to open activities.
    fun onStoreClicked(view: View) {
        val context = view.context
        val intent = StoreDetailsActivity.getStartIntent(context, store.id)
        context.startActivity(intent)
    }

    private fun formatDistance(distance: Number?): String {
        return distance?.toDouble()?.round(2)
            .toString() + " KM" // Strings would need to be in strings.xml for localizations
    }

    private fun formatDescription(description: String): String {
        val keyWords = description.split(",")
        if (keyWords.size >= 2) {
            return keyWords[0] + "," + keyWords[1]
        }
        return description
    }

    private fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()


}