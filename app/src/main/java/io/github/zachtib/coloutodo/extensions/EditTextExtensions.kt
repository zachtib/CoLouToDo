package io.github.zachtib.coloutodo.extensions

import android.widget.EditText

val EditText.textValue: String
    get() = this.text.toString()