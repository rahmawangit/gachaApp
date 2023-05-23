package com.example.gacha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gacha.databinding.ActivityHasilBinding

class hasil : AppCompatActivity() {
    lateinit var binding: ActivityHasilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        binding = ActivityHasilBinding.inflate(layoutInflater)

        val ambilPemenang = intent.getStringExtra("finalGacha") // AMBIL VALUE DARI SEBELAH
        binding.tvHasil.text = ambilPemenang.toString()               // SETTING TEKS KE TV HASIL

        binding.buttMantap.setOnClickListener(){                // BALIK GACHA LAGI
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}