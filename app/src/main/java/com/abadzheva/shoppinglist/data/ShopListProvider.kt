package com.abadzheva.shoppinglist.data

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.abadzheva.shoppinglist.domain.ShopItem
import com.abadzheva.shoppinglist.presentation.ShopApplication
import javax.inject.Inject

class ShopListProvider : ContentProvider() {
    private val component by lazy {
        (context as ShopApplication).component
    }

    @Inject
    lateinit var shopListDao: ShopListDao

    @Inject
    lateinit var mapper: ShopListMapper

    private val uriMatcher =
        UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(
                "com.abadzheva.shoppinglist",
                "shop_items",
                GET_SHOP_ITEMS_QUERY,
            )
            addURI(
                "com.abadzheva.shoppinglist",
                "shop_items/#",
                GET_SHOP_ITEMS_BY_ID_QUERY,
            )
        }

    override fun onCreate(): Boolean {
        component.inject(this)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String?>?,
        selection: String?,
        selectionArgs: Array<out String?>?,
        sortOrder: String?,
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                return shopListDao.getShopListCursor()
            }

            else -> {
                null
            }
        }
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(
        uri: Uri,
        values: ContentValues?,
    ): Uri? {
        when (uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                if (values == null) return null
                val id = values.getAsInteger("id")
                val name = values.getAsString("name")
                val count = values.getAsInteger("count")
                val enabled = values.getAsBoolean("enabled")
                val shopItem =
                    ShopItem(
                        id = id,
                        name = name,
                        count = count,
                        enabled = enabled,
                    )
                shopListDao.addShopItemSync(mapper.mapEntityToDbModel(shopItem))
            }
        }
        return null
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<out String?>?,
    ): Int {
        when (uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                val id = selectionArgs?.get(0)?.toInt() ?: -1
                return shopListDao.deleteShopItemSync(id)
            }
        }
        return 0
    }

    override fun update(
        p0: Uri,
        p1: ContentValues?,
        p2: String?,
        p3: Array<out String?>?,
    ): Int {
        TODO("Not yet implemented")
    }

    companion object {
        private const val GET_SHOP_ITEMS_QUERY = 100
        private const val GET_SHOP_ITEMS_BY_ID_QUERY = 101
    }
}
