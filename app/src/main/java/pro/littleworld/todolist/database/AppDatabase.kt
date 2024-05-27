package pro.littleworld.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pro.littleworld.todolist.model.Todo

@Database(entities = [Todo::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,
                AppDatabase::class.java,
                "todo_database")
                .build()
        }
    }
}