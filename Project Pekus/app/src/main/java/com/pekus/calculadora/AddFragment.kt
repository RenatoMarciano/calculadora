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
    var operacao = ""

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
            operacao = "+"

            if (binding.editTextValorA.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo A.", Toast.LENGTH_LONG).show()
            } else if (binding.editTextValorB.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo B.", Toast.LENGTH_LONG).show()
            } else {
                val valor1 = binding.editTextValorA.text.toString()
                val valor2 = binding.editTextValorB.text.toString()

                resultado = (valor1.toInt() + valor2.toInt())

                inserirNoBanco()
            }
        }

        binding.btnSubtracao.setOnClickListener {
            operacao = "-"

            if (binding.editTextValorA.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo A.", Toast.LENGTH_LONG).show()
            } else if (binding.editTextValorB.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo B.", Toast.LENGTH_LONG).show()
            } else {
                val valor1 = binding.editTextValorA.text.toString()
                val valor2 = binding.editTextValorB.text.toString()

                resultado = (valor1.toInt() - valor2.toInt())

                inserirNoBanco()
            }
        }

        binding.btnMultiplicacao.setOnClickListener {
            operacao = "*"

            if (binding.editTextValorA.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo A.", Toast.LENGTH_LONG).show()
            } else if (binding.editTextValorB.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo B.", Toast.LENGTH_LONG).show()
            } else {
                val valor1 = binding.editTextValorA.text.toString()
                val valor2 = binding.editTextValorB.text.toString()

                resultado = (valor1.toInt() * valor2.toInt())

                inserirNoBanco()
            }
        }

        binding.btnDivisao.setOnClickListener {
            operacao = "/"

            if (binding.editTextValorA.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo A.", Toast.LENGTH_LONG).show()
            } else if (binding.editTextValorB.text.isNullOrEmpty()) {
                Toast.makeText(context, "Informe o campo B.", Toast.LENGTH_LONG).show()
            } else {
                val valor1 = binding.editTextValorA.text.toString()
                val valor2 = binding.editTextValorB.text.toString()

                resultado = (valor1.toInt() / valor2.toInt())

                inserirNoBanco()
            }
        }

        return binding.root
    }

    fun inserirNoBanco() {

        val valor1 = binding.editTextValorA.text.toString()
        val valor2 = binding.editTextValorB.text.toString()

        val user = Calculadora(0, valor1.toInt(), operacao, valor2.toInt(),  resultado, dataHora)
        mainViewModel.addUser(user)
        Toast.makeText(context, "Cálculo armazenado com sucesso", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

}
