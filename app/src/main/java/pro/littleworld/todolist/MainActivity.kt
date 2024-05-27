package pro.littleworld.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pro.littleworld.todolist.views.TodoInput
import pro.littleworld.todolist.views.TodoList
import pro.littleworld.todolist.database.AppDatabase
import pro.littleworld.todolist.model.Todo
import pro.littleworld.todolist.ui.theme.TodolistTheme
import pro.littleworld.todolist.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.buildDatabase(applicationContext)
        val todoDao = database.todoDao()
        val viewModel = TodoViewModel(todoDao)

        setContent {
            TodolistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
            ) {
                    MyScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyScreen(viewModel: TodoViewModel) {
    Column {
        TodoInput(viewModel = viewModel)
        TodoList(viewModel = viewModel, onItemClick = {item: Todo -> viewModel.delete(item)})
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListPreview() {
    val context = LocalContext.current
    val database = AppDatabase.buildDatabase(context)

    val todoDao = database.todoDao()
    val viewModel = TodoViewModel(todoDao)

    MyScreen(viewModel = viewModel)

}