package br.com.thaysa.vozinterna

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.thaysa.vozinterna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Redirecionar para VisaoActivity (Tela Principal)
        startActivity(Intent(this, VisaoActivity::class.java))
        finish()
    }
}
