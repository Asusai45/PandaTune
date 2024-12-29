package com.adityaproj.panda_tune

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.login)
        val button2=findViewById<Button>(R.id.signup)
        button.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)

        }
        button2.setOnClickListener {
            val intent=Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
    }
}

