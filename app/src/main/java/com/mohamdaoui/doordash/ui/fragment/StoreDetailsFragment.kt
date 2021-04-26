package com.mohamdaoui.doordash.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mohamdaoui.doordash.databinding.StoreDetailsBinding
import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.ui.activity.StoreDetailsActivity.Companion.ID
import com.mohamdaoui.doordash.viewmodel.MainViewModel
import com.mohamdaoui.doordash.viewmodel.StoreViewModel

class StoreDetailsFragment : Fragment() {

    companion object {
        fun newInstance(id: Int?): StoreDetailsFragment {
            val fragment = StoreDetailsFragment()
            if (id == null) return fragment
            val args = Bundle()
            args.putInt(ID, id)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: StoreDetailsBinding
    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StoreDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainVM = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val arguments = arguments ?: return
        val id = arguments.getInt(ID)
        mainVM.getRestaurantDetails(id).observe(this,
            Observer<Store> { store ->
                viewModel = StoreViewModel(store = store)
                binding.storeVM = viewModel
            })
    }

}