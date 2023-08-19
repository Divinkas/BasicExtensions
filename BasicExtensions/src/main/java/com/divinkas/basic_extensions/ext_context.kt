package com.divinkas.basic_extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

fun Context.getVerticalLinearLayoutManager(): LinearLayoutManager =
    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

fun Context.getHorizontalLinearLayoutManager(): LinearLayoutManager =
    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

fun Context.getGridLayoutManager(columnCount: Int): GridLayoutManager =
    GridLayoutManager(this, columnCount)

fun Context.getCompatColor(@ColorRes colorRes: Int) =
    ContextCompat.getColor(this, colorRes)

fun Context.toast(mgs: String = "", isLongDuration: Boolean = false) {
    Toast.makeText(this, mgs, if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun Context.getDisplayWidth(): Int = this.resources.displayMetrics.widthPixels
fun Context.getDisplayHeight(): Int = this.resources.displayMetrics.heightPixels

fun Context.openLink(link: String, withFlags: (Intent) -> Unit = {}) {
    if (link.isEmpty()) return
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply { withFlags.invoke(this) }
    startActivity(browserIntent)
}
