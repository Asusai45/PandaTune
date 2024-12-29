package com.adityaproj.panda_tune

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton

class MainActivity7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val btnimg: ImageButton = findViewById(R.id.imagebb)
        val btnimg2: ImageButton = findViewById(R.id.imagebb1)
        val btnimg3: ImageButton = findViewById(R.id.imagebb2)
        val btnimg4: ImageButton = findViewById(R.id.imagebb3)

        val songs = listOf(
            R.raw.bhool,
            R.raw.husn,
            R.raw.arjan,
            R.raw.payal
        )

        val images = listOf(
            R.drawable.bhool,
            R.drawable.husn,
            R.drawable.ranveer,
            R.drawable.payal
        )

        btnimg.setOnClickListener {
            navigateToPlayer(songs[0], images[0])
        }
        btnimg2.setOnClickListener {
            navigateToPlayer(songs[1], images[1])
        }
        btnimg3.setOnClickListener {
            navigateToPlayer(songs[2], images[2])
        }
        btnimg4.setOnClickListener {
            navigateToPlayer(songs[3], images[3])
        }
    }

    private fun navigateToPlayer(songId: Int, imageResId: Int) {
        val intent = Intent(this, MainActivity8::class.java)
        intent.putExtra("songId", songId)
        intent.putExtra("imageResId", imageResId)
        startActivity(intent)
    }
}
