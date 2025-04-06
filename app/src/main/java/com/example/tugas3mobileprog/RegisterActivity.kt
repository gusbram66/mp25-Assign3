package com.example.tugas3mobileprog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas3mobileprog.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (validateInputs()) {
                val user = User(
                    username = binding.etName.text.toString(),
                    password = binding.etPassword.text.toString()
                )

                // Kirim data user ke LoginActivity via Intent
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("REGISTERED_USER", user) // Gunakan Parcelable
                }
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val name = binding.etName.text.toString()
        val password = binding.etPassword.text.toString()

        if (name.isEmpty()) {
            binding.etName.error = "Name is required"
            return false
        }
        if (password.isEmpty() || password.length < 6) {
            binding.etPassword.error = "Password must be 6+ characters"
            return false
        }
        return true
    }
}