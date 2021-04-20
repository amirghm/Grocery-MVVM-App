package com.amirghm.gerocery.ui.catalog

import androidx.lifecycle.*
import com.amirghm.gerocery.data.model.catalog.CatalogModel
import com.amirghm.gerocery.data.repository.CatalogRepository
import com.amirghm.gerocery.ui.catalog.mapper.mapCatalogResponseToUIList
import com.amirghm.gerocery.utils.helper.network.ErrorModel
import com.amirghm.gerocery.utils.helper.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(var catalogRepository: CatalogRepository) :
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