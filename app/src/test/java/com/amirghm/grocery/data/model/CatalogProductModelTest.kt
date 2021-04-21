package com.amirghm.grocery.data.model

import com.amirghm.grocery.Constants
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Test

class CatalogProductModelTest {
    @Test
    fun `give price and currency and return formatted one`() {
        val catalogModel = Constants.FAKE_CATALOG_MODEL
        val formattedAmount = catalogModel.getAmountWithCurrency()
        MatcherAssert.assertThat(
            formattedAmount,
            IsEqual("${catalogModel.amount} ${catalogModel.currency}")
        )
    }
}