package com.abadzheva.shoppinglist.presentation

import android.app.Application
import com.abadzheva.shoppinglist.di.DaggerApplicationComponent

class ShopApplication : Application() {
    val component by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}
