package com.example.calculadoraimc

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calculadoraimc.Dao.UsuarioDao
import com.example.calculadoraimc.model.Usuarios

@Database(entities = [Usuarios::class], version = 5)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UsuarioDao(): UsuarioDao
    companion object{
        private const val DATABASE_NOME = "IMC_USUARIOS"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NOME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}

