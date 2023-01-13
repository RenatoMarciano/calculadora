package com.pekus.calculadora

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pekus.calculadora.data.Calculadora
import com.pekus.calculadora.data.UserDatabase
import com.pekus.calculadora.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application) : AndroidViewModel(application) {

    val selectUsers: LiveData<List<Calculadora>>
    val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
    }

    fun addUser(calculadora: Calculadora){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addUser(calculadora)
        }
    }
}