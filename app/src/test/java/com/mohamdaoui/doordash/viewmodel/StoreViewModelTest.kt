package com.mohamdaoui.doordash.viewmodel

import com.mohamdaoui.doordash.model.Store
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StoreViewModelTest {

    private lateinit var storeViewModel: StoreViewModel
    private lateinit var store: Store

    @Before
    fun init() {
        store = Store(id = 1, name = "Name", description = "tag1, tag2, tag3, tag4")
        store.coverImage = "https://dummyurl"
        store.distance = 2.897434
        storeViewModel = StoreViewModel(store = store)
    }

    @Test
    fun formatDescriptionMultipleToTwo() {
        Assert.assertEquals(storeViewModel.description, "tag1, tag2")
    }

    @Test
    fun formatDescriptionLessThanTwo() {
        store.description = "tag1 something"
        storeViewModel = StoreViewModel(store = store)
        Assert.assertEquals(storeViewModel.description, "tag1 something")
    }

    @Test
    fun formatDescriptionTwo() {
        store.description = "tag1, tag2"
        storeViewModel = StoreViewModel(store = store)
        Assert.assertEquals(storeViewModel.description, "tag1, tag2")
    }

    @Test
    fun formatDistanceRoundUp() {
        Assert.assertEquals(storeViewModel.distance, "2.9 KM")
    }

    @Test
    fun formatDistanceExact() {
        store.distance = 2.71432
        storeViewModel = StoreViewModel(store = store)
        Assert.assertEquals(storeViewModel.distance, "2.71 KM")
    }
}