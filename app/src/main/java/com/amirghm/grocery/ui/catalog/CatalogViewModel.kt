package com.amirghm.grocery.ui.catalog

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.amirghm.grocery.data.model.catalog.CatalogModel
import com.amirghm.grocery.data.repository.CatalogRepository
import com.amirghm.grocery.ui.catalog.mapper.mapCatalogResponseToUIList
import com.amirghm.grocery.utils.helper.network.ErrorModel
import com.amirghm.grocery.utils.helper.network.Result
import kotlinx.coroutines.flow.collect

class CatalogViewModel @ViewModelInject constructor(var catalogRepository: CatalogRepository) :
    ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    private val refreshList = MutableLiveData<Boolean>().apply { value = true }
    val errorModel = MutableLiveData<ErrorModel?>()
    val catalogList: MutableLiveData<List<CatalogModel>>
        get() = _catalogList as MutableLiveData<List<CatalogModel>>

    private var _catalogList: LiveData<List<CatalogModel>> = refreshList.switchMap {
        isLoading.value = true
        getProducts()
    }

    private fun getProducts() = liveData {
        catalogRepository.getProducts().collect { result->
            isLoading.value = false
            when (result.status) {
                Result.Status.ERROR -> {
                    errorModel.postValue(result.errorModel)
                }
                Result.Status.SUCCESS -> {
                    emit(mapCatalogResponseToUIList(result.data))
                }
            }
        }
    }

    fun refreshList() {
        refreshList.value = true
    }
}