package com.example.moviedb.main

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat.START
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviedb.R.id
import com.example.moviedb.R.layout
import com.example.moviedb.base.BaseActivity
import com.example.moviedb.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var navController: NavController

    override fun getLayoutResoureId() = layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mainActivity = this
        navController = findNavController(id.container)
        setSupportActionBar(mBinding.appBar.toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(
            id.nav_popular,
            id.nav_now_playing
        ), mBinding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        mBinding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun navigateTo(view: View){
        when(view.id){
            id.nav_popular -> navController.navigate(id.nav_popular)
            id.nav_now_playing -> navController.navigate(id.nav_now_playing)
        }
        mBinding.drawerLayout.closeDrawer(START)
    }
}
