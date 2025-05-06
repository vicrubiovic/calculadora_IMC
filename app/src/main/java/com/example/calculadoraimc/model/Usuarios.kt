package com.example.calculadoraimc.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_usuarios")
data class Usuarios(

    @ColumnInfo(name = "nome") var nome: String,
    @ColumnInfo(name = "idade") var idade: Int,
    @ColumnInfo(name = "peso") var peso: Float,
    @ColumnInfo(name = "altura") var altura: Float,
    @ColumnInfo(name = "imc") var imc: Float
){
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
}