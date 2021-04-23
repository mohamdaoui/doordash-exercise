package com.mohamdaoui.doordash.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mohamdaoui.doordash.R
import com.mohamdaoui.doordash.ui.fragment.StoreDetailsFragment

class StoreDetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, StoreDetailsActivity::class.java)
            intent.putExtra(ID, id)
            return intent
        }

        const val ID = "ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.store_activity)
        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction =
                fragmentManager.beginTransaction()
            val extras = intent.extras
            val id =
                extras?.getInt(ID)
            val fragment: Fragment = StoreDetailsFragment.newInstance(id)
            fragmentTransaction.add(
                R.id.container,
                fragment
            )
            fragmentTransaction.commit()
        }
    }
}