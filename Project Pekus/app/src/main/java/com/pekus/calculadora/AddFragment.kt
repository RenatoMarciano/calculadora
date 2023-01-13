package com.pekus.calculadora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pekus.calculadora.data.Calculadora
import com.pekus.calculadora.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: MainViewModel
    var resultado = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnAdicao.setOnClickListener {
            inserirNoBanco()

        }

        return binding.root
    }

    fun verificarCampos(valor1: String, valor2: String): Boolean{
        return !(valor1 == "" || valor2 == "")
    }

    fun inserirNoBanco() {
        val valor1 = binding.editTextValorA.text.toString().toInt()
        val valor2 = binding.editTextValorB.text.toString().toInt()

        resultado = (valor1 + valor2)

        if (verificarCampos(valor1.toString(), valor2.toString())){
            val user = Calculadora(0, valor1.toInt(), valor2.toInt(), resultado)
            mainViewModel.addUser(user)
            Toast.makeText(context, "Dados Adicionado!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }



       /* if (verificarCampos(valor1, valor2)){
            val user = Calculadora(0, valor1.toInt(), valor2.toInt(), resultado)
            mainViewModel.addUser(user)
            Toast.makeText(context, "Dados Adicionado!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }

        */
    }

}
