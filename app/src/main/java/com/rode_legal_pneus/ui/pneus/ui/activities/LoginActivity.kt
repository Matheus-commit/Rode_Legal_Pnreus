package com.rode_legal_pneus.ui.pneus.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.rode_legal_pneus.databinding.LoginscreenBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginscreenBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { view ->

            val email = binding.editEmail.text.toString()
            val senha = binding.editPassword.text.toString()

            if(email.isEmpty() || senha.isEmpty()){

                var snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()

            } else{

                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->

                    if(autenticacao.isSuccessful)
                        navegarTelaPrincipal()
                }.addOnFailureListener {

                    var snackbar = Snackbar.make(view, "Erro ao fazer login do usuário!", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }

        }


        binding.textNewAccount.setOnClickListener { view ->

            getRegisterScreen()
        }

        binding.textForgot.setOnClickListener { view ->

            getForgotScreen()

        }

    }

    fun navegarTelaPrincipal (){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun getRegisterScreen(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun getForgotScreen(){
        var intent = Intent(this, ForgotActivity::class.java)
        startActivity(intent)
    }

    override fun onStart (){
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if(usuarioAtual != null){
            navegarTelaPrincipal()
        }
    }

}
