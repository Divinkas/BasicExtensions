package com.divinkas.basic_extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible(isVisible: Boolean = true, isGone: Boolean = true) {
    visibility = when {
        isVisible -> View.VISIBLE
        isGone -> View.GONE
        else -> View.INVISIBLE
    }
}

fun View.gone() {
    visibility = View.GONE
}

fun View.showSoftKeyboard() {
    post {
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}