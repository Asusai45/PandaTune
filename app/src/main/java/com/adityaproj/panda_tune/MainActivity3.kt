package com.adityaproj.panda_tune

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.adityaproj.panda_tune.databinding.ActivityMain3Binding
import com.google.firebase.auth.FirebaseAuth


 class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener {
            val email = binding.emailwa.text.toString().trim()
            val password = binding.passwordwa.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "You are logged in!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, navigationwala::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                task.exception?.message ?: "Login failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter both email and password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
