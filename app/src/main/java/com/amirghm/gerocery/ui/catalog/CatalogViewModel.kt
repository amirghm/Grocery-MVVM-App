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

    init {
        val MOCK_DATA = arrayListOf(
            CatalogHeaderModel("123","Food"),
            CatalogProductModel("42","Bread","/Bread.jpg","Very Good","0.5","EUR"),
            CatalogProductModel("422","Milk","/Milk.jpg","Very Good","6.25","EUR"),
            CatalogProductModel("1","Sandwich","/Sandwich.jpg","Very Good","10","EUR"),
            CatalogProductModel("4412","Cake","/Cake.jpg","Very Good","4.0","EUR"),
            CatalogHeaderModel("123","Drink"),
            CatalogProductModel("4412","Juice","/Juice.jpg","","0.20","EUR"),
            CatalogProductModel("1","Fanta","/Fanta.jpg","Very Good","10","EUR"),
            CatalogProductModel("4412","Beer","/Beer.jpg","Very Good","1.0","EUR"),
            CatalogProductModel("422","Cola","/Cola.jpg","Very Good","2.45","EUR"),
        )
        catalogList.value?.clear()
        catalogList.value=MOCK_DATA
    }
}