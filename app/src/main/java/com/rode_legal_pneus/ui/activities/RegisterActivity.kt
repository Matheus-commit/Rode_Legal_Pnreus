package com.rode_legal_pneus.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.RegisterscreenBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var  binding: RegisterscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {view ->

            var email = binding.editEmail.text.toString()
            var senha = binding.editPassword.text.toString()

            if(email.isEmpty() || senha.isEmpty()){

                var snackbar = Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }
    }
}