package com.abadzheva.shoppinglist.di

import android.app.Application
import com.abadzheva.shoppinglist.data.AppDatabase
import com.abadzheva.shoppinglist.data.ShopListDao
import com.abadzheva.shoppinglist.data.ShopListRepositoryImpl
import com.abadzheva.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideShopListDao(application: Application): ShopListDao =
            AppDatabase
                .getInstance(application)
                .shopListDao()
    }
}
