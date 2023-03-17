package com.rode_legal_pneus.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.RegisterScreenBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var  binding: RegisterScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonregister.setOnClickListener {

            val email1 = binding.email.text.toString()
            val senha = binding.pass.text.toString()

        }
    }
}