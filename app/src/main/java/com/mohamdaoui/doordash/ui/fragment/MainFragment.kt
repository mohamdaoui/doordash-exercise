package com.mohamdaoui.doordash.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamdaoui.doordash.adapter.StoresAdapter
import com.mohamdaoui.doordash.databinding.HomeBannerBinding
import com.mohamdaoui.doordash.databinding.MainFragmentBinding
import com.mohamdaoui.doordash.model.StoreFeedResult
import com.mohamdaoui.doordash.viewmodel.HomeBannerVM
import com.mohamdaoui.doordash.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var homeBannerBinding: HomeBannerBinding
    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var homeBannerVM: HomeBannerVM
    private var storesAdapter: StoresAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val storesRecyclerView = binding.storesRecyclerView
        storesRecyclerView.layoutManager = LinearLayoutManager(activity)
        storesAdapter = StoresAdapter()
        storesRecyclerView.adapter = storesAdapter
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        homeBannerVM = HomeBannerVM(activity?.applicationContext)
        homeBannerBinding = binding.banner
        homeBannerBinding.homeBannerVM = homeBannerVM
        viewModel.getHomeFeed().observe(this,
            Observer<StoreFeedResult> { storeFeedResult ->
                storesAdapter?.setStoreList(storeFeedResult.stores)
            })

        // We can add pagination by adding a listener for the scroller, and calling the getHomeFeed with new offset.
        // Alternatively, if we use a custom callback, the VM would have access to the pagination info and can just
        // have a nextPage method
    }

}