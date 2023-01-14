package com.pekus.calculadora.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class Calculadora (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var valor1: Int,
    var operacao: String,
    var valor2: Int,
    var resultado: Int,
    var dataHora: String
){

}