package com.abadzheva.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import com.abadzheva.shoppinglist.R
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorInputName")
fun bindErrorInputName(
    textInputLayout: TextInputLayout,
    isError: Boolean,
) {
    val message =
        if (isError) {
            textInputLayout.context.getString(R.string.error_input_name)
        } else {
            null
        }
    textInputLayout.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(
    textInputLayout: TextInputLayout,
    isError: Boolean,
) {
    val message =
        if (isError) {
            textInputLayout.context.getString(R.string.error_input_count)
        } else {
            null
        }
    textInputLayout.error = message
}
