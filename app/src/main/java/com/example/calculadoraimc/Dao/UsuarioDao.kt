package com.example.calculadoraimc.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.calculadoraimc.model.Usuarios


@Dao
interface UsuarioDao {

    @Insert
    fun inserir(listaUsuarios: MutableList<Usuarios>)

    @Query("SELECT * FROM tabela_usuarios ORDER BY uid ASC")
    fun get(): MutableList<Usuarios>

    @Query(
        "UPDATE tabela_usuarios SET nome = :novoNome, idade = :novaIdade, peso = :novoPeso, altura = :novoAltura " +
                "WHERE UID = :id"
    )

    fun atualizar(
        id: Int,
        novoNome: String,
        novoPeso: String,
        novaIdade: String,
        novoAltura: String
    )

    @Query("DELETE FROM tabela_usuarios WHERE uid = :id")
    fun deletar(id: Int)
}