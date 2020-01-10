package com.example.moviedb.nowplaying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.moviedb.R
import com.example.moviedb.base.BaseFragment
import com.example.moviedb.databinding.FragmentNowPlayingBinding

/**
 * A simple [Fragment] subclass.
 */
class NowPlayingFragment : BaseFragment<FragmentNowPlayingBinding>() {

    override fun getLayoutResourceId() = R.layout.fragment_now_playing
}
