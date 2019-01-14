package io.github.zachtib.coloutodo.extensions

import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun View.visible(isVisible: Boolean) {
    this.visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View.onClick(action: suspend () -> Unit) {
    setOnClickListener {
        GlobalScope.launch(Dispatchers.Main) {
            action()
        }
    }
}

fun View.onLongClick(action: suspend () -> Unit) {
    setOnLongClickListener {
        GlobalScope.launch(Dispatchers.Main) {
            action()
        }
        true
    }
}