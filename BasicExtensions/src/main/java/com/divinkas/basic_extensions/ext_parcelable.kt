package com.divinkas.basic_extensions

import android.content.Intent
import android.os.Build
import android.os.Bundle

inline fun <reified T> Intent.parcelable(key: String, clazz: Class<T>): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableExtra(key, clazz)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T> Bundle.parcelable(key: String, clazz: Class<T>): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelable(key, clazz)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
