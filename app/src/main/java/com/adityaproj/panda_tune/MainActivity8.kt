package com.adityaproj.panda_tune

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity8 : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentSongIndex = 0
    private var isPlaying = false
    private val songs = listOf(
        R.raw.bhool,
        R.raw.husn,
        R.raw.arjan,
        R.raw.payal
    )
    private val imageList = listOf(
        R.drawable.bhool,
        R.drawable.husn,
        R.drawable.ranveer,
        R.drawable.payal
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        val imageView: ImageView = findViewById(R.id.imagebutton)
        val playButton: ImageButton = findViewById(R.id.playbutton)
        val nextButton: ImageButton = findViewById(R.id.nextbutton)
        val prevButton: ImageButton = findViewById(R.id.previousbutton)
        imageView.setImageResource(imageList[currentSongIndex])
        setupMediaPlayer(imageView)

        playButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer?.pause()
                isPlaying = false
                playButton.setImageResource(android.R.drawable.ic_media_play)
            } else {
                mediaPlayer?.start()
                isPlaying = true
                playButton.setImageResource(android.R.drawable.ic_media_pause)
            }
        }

        nextButton.setOnClickListener {
            currentSongIndex = (currentSongIndex + 1) % songs.size
            setupMediaPlayer(imageView)
        }

        prevButton.setOnClickListener {

            currentSongIndex = if (currentSongIndex == 0) {
                songs.size - 1
            } else {
                currentSongIndex - 1
            }
            setupMediaPlayer(imageView)
        }

        mediaPlayer?.setOnCompletionListener {
            currentSongIndex = (currentSongIndex + 1) % songs.size
            setupMediaPlayer(imageView)
        }
    }

    private fun setupMediaPlayer(imageView: ImageView) {
        mediaPlayer?.release()

        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex])

        imageView.setImageResource(imageList[currentSongIndex])

        isPlaying = false
        findViewById<ImageButton>(R.id.playbutton).setImageResource(android.R.drawable.ic_media_play)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}






