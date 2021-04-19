package com.amirghm.mobiquitysample.di

import com.amirghm.mobiquitysample.data.repository.CatalogRepository
import com.amirghm.mobiquitysample.data.source.remote.CatalogApi
import com.amirghm.mobiquitysample.data.source.remote.CatalogDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteCatalogDataSource

    @RemoteCatalogDataSource
    @Provides
    fun provideRemoteCatalogDataSource(@NetworkModule.Catalog catalogApiService: CatalogApi): CatalogDataSource =
        CatalogDataSource(catalogApiService)

    @Provides
    fun provideCatalogRepository(@RemoteCatalogDataSource remoteCatalogDataSource: CatalogDataSource): CatalogRepository =
        CatalogRepository(remoteCatalogDataSource)

    @Singleton
    @NetworkModule.Catalog
    @Provides
    fun provideCatalogApiService(retrofit: Retrofit): CatalogApi =
        retrofit.create(CatalogApi::class.java)
}