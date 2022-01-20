package com.example.markdown

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.markdown.fragments.LaTex
import com.example.markdown.fragments.LaTexDirections
import com.example.markdown.fragments.MarkdownFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView

class MarkDownActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_down)


        setSupportActionBar(findViewById(R.id.toolbar))
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.html,
                R.id.laTex,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)


        findViewById<BottomNavigationView>(R.id.nav_view).apply {

            this.setupWithNavController(
                Navigation.findNavController(
                    this@MarkDownActivity,
                    R.id.nav_host_fragment
                )
            )
        }


    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()








    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}