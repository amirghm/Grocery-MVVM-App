package com.amirghm.gerocery.ui.catalog

import androidx.lifecycle.*
import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.data.model.catalog.CatalogModel
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel
import com.amirghm.gerocery.data.repository.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(var catalogRepository: CatalogRepository) :
    ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val catalogList= MutableLiveData<MutableList<CatalogModel>>()
}