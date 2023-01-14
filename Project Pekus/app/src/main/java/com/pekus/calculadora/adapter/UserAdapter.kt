package com.pekus.calculadora.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pekus.calculadora.data.Calculadora
import com.pekus.calculadora.databinding.CardLayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var listUser = emptyList<Calculadora>()

    class UserViewHolder (val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]

        holder.binding.textViewId.text = user.id.toString()
        holder.binding.textViewValorA.text = user.valor1.toString()
        holder.binding.textViewOper.text = user.operacao.toString()
        holder.binding.textViewValorB.text = user.valor2.toString()
        holder.binding.textViewResult.text = user.resultado.toString()
        holder.binding.textViewDataHora.text = user.dataHora.toString()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setList(list: List<Calculadora>) {
        listUser = list
        notifyDataSetChanged()
    }
}