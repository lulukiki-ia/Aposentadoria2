package com.example.exercicio3

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercicio3.databinding.ActivityMainBinding

const val indiceMasculino = 65
const val indiceFeminino = 62
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Dados para o Spinner
        val items = listOf("masculino", "feminina")

        //Atribuido a lsita ao adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerSexo.adapter = adapter

        //Acinando o evento clique do botão
        binding.buttonCalcular.setOnClickListener {
            val sexoselecionado = binding.spinnerSexo.selectedItem.toString()
            val idade = binding.editTextIdade.text.toString().toLongOrNull()

            var resultado: Long =0L

            if (idade!= null){

                //MASCULINO
                if(sexoselecionado.trim() =="masculino") {
                    resultado = indiceMasculino - idade
                }else{
                resultado = indiceFeminino - idade }
                    if (resultado <= 0) {
                        binding.textViewResultado.text = getString(R.string.aposentado)
                    }else{
                        binding.textViewResultado.text = getString(R.string.tempo_restante, resultado)
                    }
            }else {
                binding.textViewResultado.text = getString(R.string.idadeInvalida)
            }




