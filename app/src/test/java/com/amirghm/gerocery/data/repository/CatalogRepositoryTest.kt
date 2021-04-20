package com.amirghm.gerocery.data.repository

import com.amirghm.gerocery.BaseTest
import com.amirghm.gerocery.data.source.remote.CatalogApi
import com.amirghm.gerocery.data.source.remote.CatalogRemoteDataSourceImpl
import com.amirghm.gerocery.utils.helper.network.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

internal class CatalogRepositoryTest : BaseTest() {

    private lateinit var catalogRepositoryImpl: CatalogRepositoryImpl
    private lateinit var remoteDataSourceImpl: CatalogRemoteDataSourceImpl

    @Before
    override fun setup() {
        super.setup()
        remoteDataSourceImpl =
            CatalogRemoteDataSourceImpl(getApiService(CatalogApi::class.java))
        catalogRepositoryImpl = CatalogRepositoryImpl(remoteDataSourceImpl)
    }

    @Test
    fun `get catalog return list of catalog`() {
        runBlocking {
            val result = catalogRepositoryImpl.getProducts()
            result.collect {
                MatcherAssert.assertThat(it.status, `is`(Result.Status.SUCCESS))
                MatcherAssert.assertThat(it.data, `is`(notNullValue()))
                MatcherAssert.assertThat(it.data!!.size, `is`(2))
            }
        }
    }

    @Test
    fun `get catalog return result success`() {
        runBlocking {
            val result = catalogRepositoryImpl.getProducts()
            result.collect {
                MatcherAssert.assertThat(it.status, `is`(Result.Status.SUCCESS))
            }
        }
    }
}