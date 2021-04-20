package com.amirghm.gerocery.view.catalog.mapper

import com.amirghm.gerocery.BuildConfig
import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel
import com.amirghm.gerocery.ui.catalog.mapper.getImageUrl
import com.amirghm.gerocery.ui.catalog.mapper.mapCatalogResponseToUIList
import com.amirghm.gerocery.Constants.FAKE_IMAGE_URL
import com.amirghm.gerocery.Constants.FAKE_RESPONSE_MODEL
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsInstanceOf
import org.junit.Test

class CatalogResponseToUIModelKtTest {

    @Test
    fun `give catalog network response model and read the data is same`() {
        val uiModel = mapCatalogResponseToUIList(FAKE_RESPONSE_MODEL)
        assertThat(uiModel[0], IsInstanceOf(CatalogHeaderModel::class.java))
        assertThat((uiModel[0] as CatalogHeaderModel).id, `is`("id"))
    }

    @Test
    fun `give catalog network response model while the list is empty`() {
        val uiModel = mapCatalogResponseToUIList(arrayListOf())
        assertThat(uiModel.size, `is`(0))
    }

    @Test
    fun `give catalog network response model convert to presentation model return list of CatalogUIModel`() {
        val uiModel = mapCatalogResponseToUIList(FAKE_RESPONSE_MODEL)
        assertThat(uiModel.size, `is`(2))
        assertThat(uiModel[0], IsInstanceOf(CatalogHeaderModel::class.java))
        assertThat(uiModel[1], IsInstanceOf(CatalogProductModel::class.java))
    }

    @Test
    fun `give product url concat with base url return image url `() {
        val imageUrl = getImageUrl(FAKE_IMAGE_URL)
        assertThat(imageUrl, IsEqual("${BuildConfig.BASE_URL}$FAKE_IMAGE_URL"))
    }

}