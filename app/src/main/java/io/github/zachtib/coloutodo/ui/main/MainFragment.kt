package io.github.zachtib.coloutodo.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.ui.FragmentView
import io.github.zachtib.coloutodo.ui.TodoAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : FragmentView(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val todoAdapter = TodoAdapter(viewModel::itemChecked)

        todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }

        viewModel.allTodoItems.observe(todoAdapter::submitList)
    }

}
