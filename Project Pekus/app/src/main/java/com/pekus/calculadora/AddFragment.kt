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
import java.text.SimpleDateFormat
import java.util.*

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: MainViewModel
    var resultado = 0

    var timestam = Date().time
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val dataHora = sdf.format(timestam)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnAdicao.setOnClickListener {
            calcular("+")
        }

        binding.btnSubtracao.setOnClickListener {
            calcular("-")
        }

        binding.btnMultiplicacao.setOnClickListener {
            calcular("*")
        }

        binding.btnDivisao.setOnClickListener {
            calcular("/")
        }
        return binding.root
    }

    fun inserirNoBanco(valor1: String, valor2: String, operation: String) {
        val user = Calculadora(0, valor1.toInt(), operation, valor2.toInt(), resultado, dataHora)
        mainViewModel.addUser(user)
        Toast.makeText(context, "Cálculo armazenado com sucesso", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

    fun validarCampos(valorOne: String, valorTwo: String): Boolean {
        if (valorOne == "") {
            Toast.makeText(context, "Informe o campo A.", Toast.LENGTH_LONG).show()
            return false
        }
        if (valorTwo == "") {
            Toast.makeText(context, "Informe o campo B.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    fun calcular(calc: String) {
        val valor1 = binding.editTextValorA.text.toString()
        val valor2 = binding.editTextValorB.text.toString()

        val response = validarCampos(valor1, valor2)

        if (response) {
            if (calc == "+") {
                resultado = (valor1.toInt() + valor2.toInt())
            } else if (calc == "-") {
                resultado = (valor1.toInt() - valor2.toInt())
            } else if (calc == "*") {
                resultado = (valor1.toInt() * valor2.toInt())
            } else {
                resultado = (valor1.toInt() / valor2.toInt())
            }
            inserirNoBanco(valor1, valor2, calc)
        }
    }
}