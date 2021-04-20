package com.amirghm.gerocery.data.source.remote

import com.amirghm.gerocery.BaseTest
import com.amirghm.gerocery.utils.helper.network.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

internal class RemoteCatalogDataSourceTest : BaseTest() {
    private lateinit var remoteDataSourceImpl: CatalogRemoteDataSourceImpl

    @Before
    override fun setup() {
        super.setup()
        remoteDataSourceImpl = CatalogRemoteDataSourceImpl(getApiService(CatalogApi::class.java))
    }

    @Test
    fun `get catalog return list of catalog`() {
        runBlocking {
            val result = remoteDataSourceImpl.getProducts()
            result.collect {
                MatcherAssert.assertThat(
                    it.status,
                    `is`(Result.Status.SUCCESS)
                )
                MatcherAssert.assertThat(it.data, `is`(notNullValue()))
                MatcherAssert.assertThat(it.data!!.size, `is`(2))
            }
        }
    }

    @Test
    fun `get catalog return success with null error model`() {
        runBlocking {
            val result = remoteDataSourceImpl.getProducts()
            result.collect {
                MatcherAssert.assertThat(
                    it.errorModel,
                    `is`(nullValue())
                )
            }
        }
    }

    @Test
    fun `get catalog return result success`() {
        runBlocking {
            val result = remoteDataSourceImpl.getProducts()
            result.collect {
                MatcherAssert.assertThat(
                    it.status,
                    `is`(Result.Status.SUCCESS)
                )
            }
        }
    }
}