package io.github.zachtib.coloutodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.github.zachtib.coloutodo.BuildConfig
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.extensions.visible
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        generateButton.visible(BuildConfig.DEBUG)

        generateButton.setOnClickListener {
            Timber.d("Generate Button clicked")
            viewModel.generateSampleData()
        }

        viewModel.allTodoItems.observe(this, Observer { items ->
            Timber.d("Got new items:")
            items.forEachIndexed { index, item ->
                Timber.d("$index: $item")
            }
        })
    }

}
