package com.adityaproj.panda_tune

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.adityaproj.panda_tune.databinding.ActivityMain4Binding
import com.google.firebase.auth.FirebaseAuth

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.register.setOnClickListener {
            val email = binding.email2.text.toString().trim()
            val password = binding.pass3.text.toString().trim()
            val confirmPassword = binding.pass4.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity3::class.java)
                                startActivity(intent)
                                finish() // Finish current activity to avoid going back
                            } else {
                                Toast.makeText(this, task.exception?.message ?: "Registration Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter all the fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
