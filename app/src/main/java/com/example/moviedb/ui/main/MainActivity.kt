package com.example.moviedb.ui.main

import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat.START
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviedb.R.id
import com.example.moviedb.R.layout
import com.example.moviedb.ui.base.BaseActivity
import com.example.moviedb.databinding.ActivityMainBinding
import com.example.moviedb.ui.adapter.GenreAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var navController: NavController

    private lateinit var viewModel: MainViewModel

    private lateinit var genreAdapter: GenreAdapter

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun setupUI() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mBinding.mainActivity = this
        navController = findNavController(id.container)
        setSupportActionBar(mBinding.appBar.toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(
            id.nav_popular,
            id.nav_now_playing
        ), mBinding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        mBinding.navView.setupWithNavController(navController)
        viewModel.loadingLiveData.observe(this, Observer {

        })

        viewModel.errorLiveData.observe(this, Observer {
            toast(it)
        })

        viewModel.mutableLiveData.observe(this, Observer {
            genreAdapter = GenreAdapter(it)
            mBinding.recyclerGenres.adapter = genreAdapter
        })
    }

    override fun loadData() {
        viewModel.getGenres()
    }

    fun navigateTo(view: TextView){
        when(view.id){
            id.nav_popular -> navController.navigate(id.nav_popular)
            id.nav_now_playing -> navController.navigate(id.nav_now_playing)
        }
        mBinding.drawerLayout.closeDrawer(START)
    }

    override val layoutResource: Int get() = layout.activity_main
}
