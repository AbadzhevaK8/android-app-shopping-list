package com.abadzheva.shoppinglist.data

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log

class ShopListProvider : ContentProvider() {
    override fun onCreate(): Boolean = true

    override fun query(
        p0: Uri,
        p1: Array<out String?>?,
        p2: String?,
        p3: Array<out String?>?,
        p4: String?,
    ): Cursor? {
        Log.d("ShopListProvider", "query: $p0")
        return null
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(
        p0: Uri,
        p1: ContentValues?,
    ): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(
        p0: Uri,
        p1: String?,
        p2: Array<out String?>?,
    ): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        p0: Uri,
        p1: ContentValues?,
        p2: String?,
        p3: Array<out String?>?,
    ): Int {
        TODO("Not yet implemented")
    }
}
