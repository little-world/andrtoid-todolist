package pro.littleworld.todolist.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import pro.littleworld.todolist.model.Todo
import pro.littleworld.todolist.viewmodel.TodoViewModel

@Composable
fun TodoList(viewModel: TodoViewModel, onItemClick: (Todo) -> Unit) {
    val todos by viewModel.getAll().collectAsState(initial = listOf())

    LazyColumn {
        items(todos) {
                todo ->
            TodoItemView(todo, onItemClick)
        }
    }
}

