package com.example.moviedb

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.moviedb.base.BaseActivity
import com.example.moviedb.databinding.ActivityMainBinding
import com.example.moviedb.databinding.AppBarMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    val navController = findNavController(R.id.container)

    val appBarMainBinding =
        DataBindingUtil.inflate<AppBarMainBinding>(LayoutInflater.from(this), R.layout.app_bar_main, null, false)

    override fun getLayoutResoureId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(appBarMainBinding.toolbar)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_popular, R.id.nav_now_playing), mBinding.drawerLayout)
    }
}
