package com.adityaproj.panda_tune
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(
    private val content: Activity,
    private var dataList: List<Data>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var currentMediaPlayer: MediaPlayer? = null

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val musicImage: ImageView = view.findViewById(R.id.musicImage)
        val title: TextView = view.findViewById(R.id.titlee)
        val play: ImageButton = view.findViewById<ImageButton>(R.id.play)
        val pause: ImageButton = view.findViewById<ImageButton>(R.id.pause)
    }

      fun Setfilteredlist(dataList: List<Data>){
          this.dataList=dataList
          notifyDataSetChanged()
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(content).inflate(R.layout.activity_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]

        holder.title.text = currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.musicImage)

        val mediaPlayer = MediaPlayer.create(content,currentData.preview.toUri())
        holder.play.setOnClickListener {
            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                    it.reset()
                }
            }
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()
        }


        holder.pause.setOnClickListener {
            mediaPlayer.pause()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}



