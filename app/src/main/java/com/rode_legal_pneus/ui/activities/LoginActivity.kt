package com.rode_legal_pneus.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.LoginscreenBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textNewAccount.setOnClickListener {

            getRegisterScreen()
        }

    }

    fun getRegisterScreen(){

        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }

}
