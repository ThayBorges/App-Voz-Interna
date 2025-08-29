package br.com.thaysa.vozinterna

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.thaysa.vozinterna.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLoginButton()
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()
            
            if (validateLogin(email, senha)) {
                // Simular autenticação bem-sucedida
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                
                // Redirecionar para VisaoActivity (Tela Principal)
                val intent = Intent(this, VisaoActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateLogin(email: String, senha: String): Boolean {
        return email.isNotEmpty() && 
               Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
               senha.isNotEmpty() && 
               senha.length >= 6
    }
}
