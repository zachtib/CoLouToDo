package io.github.zachtib.coloutodo.extensions

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikethrough(value: Boolean) = setFlag(value, Paint.STRIKE_THRU_TEXT_FLAG)

fun TextView.setFlag(value: Boolean, flag: Int) {
    paintFlags = if(value) {
        paintFlags or flag
    } else {
        paintFlags and flag.inv()
    }
}

val TextView.stringValue: String
    get() = this.text.toString()