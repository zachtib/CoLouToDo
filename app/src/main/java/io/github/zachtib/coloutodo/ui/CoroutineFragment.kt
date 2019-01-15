package io.github.zachtib.coloutodo.ui

import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class CoroutineFragment : Fragment(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        super.onDestroy()
        if (job.isActive) {
            job.cancel()
        }
    }

    fun View.onClick(action: suspend () -> Unit) {
        setOnClickListener {
            launch(Dispatchers.Main) {
                action()
            }
        }
    }

    fun View.onLongClick(action: suspend () -> Unit) {
        setOnLongClickListener {
            launch(Dispatchers.Main) {
                action()
            }
            true
        }
    }
}