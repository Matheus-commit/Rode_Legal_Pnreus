package com.rode_legal_pneus.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.ForgotScreenBinding
import java.lang.Exception

class ForgotActivity : AppCompatActivity() {

    private lateinit var binding: ForgotScreenBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ForgotScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var email = binding.editEmail.text.toString()

        binding.btnForgot.setOnClickListener { view ->

                auth.sendPasswordResetEmail(email).addOnCompleteListener{ task ->

                    if(task.isSuccessful) {

                        var snackbar = Snackbar.make(view, "E-mail enviado!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()

                    }else{
                        var snackbar = Snackbar.make(view, "Error!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()

                    }

                }
            }


        }

    }

//if(email.isEmpty()){
//
//    var snackbar = Snackbar.make(view, "Preencha o campo de e-mail", Snackbar.LENGTH_SHORT)
//    snackbar.setBackgroundTint(Color.RED)
//    snackbar.show()
//}else{