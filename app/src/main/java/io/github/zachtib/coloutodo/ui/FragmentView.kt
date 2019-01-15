package io.github.zachtib.coloutodo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import io.github.zachtib.coloutodo.extensions.stringValue
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class FragmentView(@LayoutRes private val layoutId: Int) : CoroutineFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) {
        this.observe(viewLifecycleOwner, Observer { observer(it) })
    }

    protected fun navigateToScreen(screen: Screen) {
        activity?.let { parent ->
            if (parent is MainActivity) {
                parent.navigateToScreen(screen)
            }
        }
    }

    suspend fun showTextInputDialog(
        prompt: String,
        positiveMessage: String = "OK",
        negativeMessage: String = "Cancel"
    ) = suspendCoroutine<String?> {
        val textField = EditText(context)
        AlertDialog.Builder(requireContext())
            .setMessage(prompt)
            .setView(textField)
            .setPositiveButton(positiveMessage) { _, _ -> it.resume(textField.stringValue) }
            .setNegativeButton(negativeMessage) { _, _ -> it.resume(null) }
            .create()
            .show()
    }

    suspend fun showConfirmationDialog(
        prompt: String,
        positiveMessage: String = "OK",
        negativeMessage: String = "Cancel"
    ) = suspendCoroutine<Boolean> {
        AlertDialog.Builder(requireContext())
            .setMessage(prompt)
            .setPositiveButton(positiveMessage) { _, _ -> it.resume(true) }
            .setNegativeButton(negativeMessage) { _, _ -> it.resume(false) }
            .create()
            .show()
    }
}