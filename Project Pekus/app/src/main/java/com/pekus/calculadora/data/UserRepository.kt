package com.pekus.calculadora.data

class UserRepository (private val userDao: UserDao){

    val selectUsers = userDao.selectUsers()

    fun addUser(calculadora: Calculadora){
        userDao.addUser(calculadora)
    }
}