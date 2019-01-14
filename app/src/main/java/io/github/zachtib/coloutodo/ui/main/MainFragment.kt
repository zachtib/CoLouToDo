package io.github.zachtib.coloutodo.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.data.Todo
import io.github.zachtib.coloutodo.extensions.onClick
import io.github.zachtib.coloutodo.ui.FragmentView
import io.github.zachtib.coloutodo.ui.todoadapter.TodoAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : FragmentView(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val onDeleteHandler = { todo: Todo ->
            GlobalScope.launch(Dispatchers.Main) {
                if (showConfirmationDialog("Delete \"${todo.label}\"?")) {
                    viewModel.deleteItem(todo)
                }
            }
        }

        val todoAdapter = TodoAdapter(viewModel::itemChecked, onDeleteHandler)

        todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }

        createTodoButton.onClick {
            val result = showTextInputDialog("Enter a new Todo:")
            result?.let(viewModel::newItemCreated)
        }

        viewModel.allTodoItems.observe(todoAdapter::submitList)
    }



}
