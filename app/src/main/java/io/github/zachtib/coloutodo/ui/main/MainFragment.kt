package io.github.zachtib.coloutodo.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.data.Todo
import io.github.zachtib.coloutodo.ui.FragmentView
import io.github.zachtib.coloutodo.ui.todoadapter.TodoAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : FragmentView(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    private suspend fun confirmDelete(todo: Todo) {
        if (showConfirmationDialog("Delete \"${todo.label}\"?")) {
            viewModel.deleteItem(todo)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val todoAdapter = TodoAdapter(viewModel::itemChecked, this::confirmDelete)

        todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }


        createTodoButton.onClick {
            showTextInputDialog("Enter a new Todo:")?.let(viewModel::newItemCreated)
        }

        viewModel.allTodoItems.observe(todoAdapter::submitList)
    }

}
