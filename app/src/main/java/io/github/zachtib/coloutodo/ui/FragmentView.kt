package io.github.zachtib.coloutodo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class FragmentView(@LayoutRes private val layoutId: Int) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) {
        this.observe(viewLifecycleOwner, Observer { observer(it) })
    }
}