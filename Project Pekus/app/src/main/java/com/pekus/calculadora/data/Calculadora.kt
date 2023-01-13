package com.pekus.calculadora.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table1")
class Calculadora (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var valor1: Int,
    var valor2: Int,
    var resultado: Int
){
    //var operacao= String
   // var resultado= Int
    //var DataHora= String
}