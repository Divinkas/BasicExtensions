package com.divinkas.basic_extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * @Example:
 *
 * fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
 *     val view = parent.createView(R.layout.item_your_view))
 *     return YourViewHolder(ItemCategoryClientBinding.bind(view))
 * }
 **/
fun ViewGroup.createView(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}