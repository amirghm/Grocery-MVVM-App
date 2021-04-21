package com.amirghm.grocery.di

import com.amirghm.grocery.data.repository.CatalogRepository
import com.amirghm.grocery.data.repository.CatalogRepositoryImpl
import com.amirghm.grocery.data.source.CatalogDataSource
import com.amirghm.grocery.data.source.remote.CatalogApi
import com.amirghm.grocery.data.source.remote.CatalogRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteCatalogDataSource

    @RemoteCatalogDataSource
    @Provides
    fun provideRemoteCatalogDataSource(@NetworkModule.Catalog catalogApiService: CatalogApi): CatalogDataSource =
        CatalogRemoteDataSourceImpl(catalogApiService)

    @Provides
    fun provideCatalogRepository(@RemoteCatalogDataSource remoteCatalogDataSource: CatalogDataSource): CatalogRepository =
        CatalogRepositoryImpl(remoteCatalogDataSource)

    @Singleton
    @NetworkModule.Catalog
    @Provides
    fun provideCatalogApiService(retrofit: Retrofit): CatalogApi =
        retrofit.create(CatalogApi::class.java)
}