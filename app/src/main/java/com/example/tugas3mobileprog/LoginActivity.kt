package com.example.tugas3mobileprog

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas3mobileprog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var registeredUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terima data dari RegisterActivity
        registeredUser = intent.getParcelableExtra("REGISTERED_USER")

        binding.btnLogin.setOnClickListener {
            if (validateInputs()) {
                val inputUsername = binding.etUsername.text.toString()
                val inputPassword = binding.etPassword.text.toString()

                if (registeredUser != null &&
                    inputUsername == registeredUser?.username &&
                    inputPassword == registeredUser?.password) {

                    // Login sukses, lanjut ke LandingActivity
                    val intent = Intent(this, LandingActivity::class.java).apply {
                        putExtra("LOGGED_IN_USER", registeredUser)
                    }
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateInputs(): Boolean {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        if (username.isEmpty()) {
            binding.etUsername.error = "Username required"
            return false
        }
        if (password.isEmpty()) {
            binding.etPassword.error = "Password required"
            return false
        }
        return true
    }
}