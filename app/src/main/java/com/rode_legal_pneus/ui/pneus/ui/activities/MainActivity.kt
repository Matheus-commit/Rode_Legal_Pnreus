package com.rode_legal_pneus.ui.pneus.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.rode_legal_pneus.R
import com.rode_legal_pneus.databinding.MainScreenBinding
import com.rode_legal_pneus.ui.pneus.models.Pneus
import com.rode_legal_pneus.ui.pneus.services.RetrofitInitializer
import com.rode_legal_pneus.ui.pneus.ui.adapters.PneusAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getPneus()

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getPneus(){

        var s = RetrofitInitializer().getServicePneus()
        var call = s.getPneus()

        call.enqueue(object : retrofit2.Callback<List<Pneus>>{

            override fun onResponse(call: Call<List<Pneus>>, response: Response<List<Pneus>>) {

                if (response.code() == 200){

                    response.body()?.let {
                        showPneus(it)
                    }
                }

            }

            override fun onFailure(call: Call<List<Pneus>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showPneus(list: List<Pneus>)
    {
        var listPneus = findViewById<ListView>(R.id.listPneus)
        listPneus.adapter = PneusAdapter(this, list)
    }


}