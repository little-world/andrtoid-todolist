package pro.littleworld.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pro.littleworld.todolist.database.TodoDao
import pro.littleworld.todolist.model.Todo

class TodoViewModel (val todoDao: TodoDao): ViewModel() {

    fun getAll(): Flow<List<Todo>> =
        todoDao.getAll()

    fun insert (todo: Todo) = viewModelScope.launch {
        todoDao.insert(todo)
    }

    fun update (todo: Todo) = viewModelScope.launch {
        todoDao.update(todo)
    }

    fun delete (todo: Todo) = viewModelScope.launch {
        todoDao.delete(todo)
    }
}