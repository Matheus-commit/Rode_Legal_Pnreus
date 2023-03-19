package com.rode_legal_pneus.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.RegisterscreenBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var  binding: RegisterscreenBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {view ->

            var email = binding.editEmail.text.toString()
            var senha = binding.editPassword.text.toString()
            var nome = binding.editName.text.toString()

            if(email.isEmpty() || senha.isEmpty() || nome.isEmpty()){

                var snackbar = Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->

                    if (cadastro.isSuccessful){
                        Toast.makeText(
                            this@RegisterActivity,
                            "Cadastro realizado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                        binding.editEmail.setText("")
                        binding.editPassword.setText("")
                        binding.editName.setText("")

                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->

                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido"
                        is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada"
                        is FirebaseNetworkException -> "Sem conexão com a internet"
                        else -> "Erro ao cadastrar usuário"
                    }

                    var snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }

    //fun
}