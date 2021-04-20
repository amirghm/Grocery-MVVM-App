package com.amirghm.gerocery.view.catalog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amirghm.gerocery.utils.MainCoroutineRule
import com.amirghm.gerocery.data.repository.FakeCatalogRepository
import com.amirghm.gerocery.utils.getOrAwaitValue
import com.amirghm.gerocery.utils.observeForTesting
import com.amirghm.gerocery.ui.catalog.CatalogViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CatalogViewModelTest {
    private lateinit var catalogViewModel: CatalogViewModel
    private lateinit var fakeCatalogRepository: FakeCatalogRepository

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        fakeCatalogRepository = FakeCatalogRepository()
        catalogViewModel = CatalogViewModel(fakeCatalogRepository)
    }

    @Test
    fun `get catalog from repository and return success`() {
        fakeCatalogRepository.setReturnError(false)

        catalogViewModel.refreshList()

        catalogViewModel.catalogList.observeForTesting {
            MatcherAssert.assertThat(
                catalogViewModel.catalogList.getOrAwaitValue().isEmpty(),
                CoreMatchers.`is`(false)
            )
        }
    }

    @Test
    fun `get catalog from repository with empty size`() {
        fakeCatalogRepository.setReturnError(false)
        fakeCatalogRepository.sendEmptyModel(true)
        catalogViewModel.refreshList()

        catalogViewModel.catalogList.observeForTesting {
            MatcherAssert.assertThat(
                catalogViewModel.catalogList.getOrAwaitValue().isEmpty(),
                CoreMatchers.`is`(true)
            )
        }
    }

    @Test
    fun `get catalog from repository and return error with internal server error message`() {
        fakeCatalogRepository.setReturnError(true)
        fakeCatalogRepository.setErrorMessage("Internal Server Error")

        catalogViewModel.refreshList()

        catalogViewModel.catalogList.observeForTesting {
            MatcherAssert.assertThat(
                catalogViewModel.errorModel.getOrAwaitValue()?.message,
                CoreMatchers.`is`("Internal Server Error")
            )
        }
    }

    @Test
    fun `get catalog from repository and return error with server error`() {
        fakeCatalogRepository.setReturnError(true)
        fakeCatalogRepository.setReturnCode(500)

        catalogViewModel.refreshList()

        catalogViewModel.catalogList.observeForTesting {
            MatcherAssert.assertThat(
                catalogViewModel.errorModel.getOrAwaitValue()?.code,
                CoreMatchers.`is`(500)
            )
        }
    }

    @Test
    fun `get catalog from repository and return error`() {
        fakeCatalogRepository.setReturnError(true)

        catalogViewModel.refreshList()

        catalogViewModel.catalogList.observeForTesting {
            MatcherAssert.assertThat(
                catalogViewModel.errorModel.getOrAwaitValue()?.code,
                CoreMatchers.`is`(404)
            )
        }
    }
}