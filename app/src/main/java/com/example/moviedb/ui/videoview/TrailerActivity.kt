package com.example.moviedb.ui.videoview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.MediaController
import com.example.moviedb.R
import com.example.moviedb.databinding.ActivityTrailerBinding
import com.example.moviedb.ui.base.BaseActivity


class TrailerActivity : BaseActivity<ActivityTrailerBinding>() {

    override val layoutResource: Int get() = R.layout.activity_trailer

    override fun loadData() {
        val url = intent.getStringExtra(EXTRA_URL)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController);
        binding.videoView.setVideoURI(Uri.parse("rtsp://v6.cache4.c.youtube.com/CigLENy73wIaHwmh5W2TKCuN2RMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp"))
        binding.videoView.start()
    }

    override fun setupUI() {
    }

    companion object {
        fun start(context: Context, url: String?){
            val intent = Intent(context, TrailerActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            context.startActivity(intent)
        }

        private const val EXTRA_URL = "EXTRA_URL"
    }
}
