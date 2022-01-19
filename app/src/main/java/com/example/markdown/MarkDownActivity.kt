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

class MarkDownActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    NavController.OnDestinationChangedListener {



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
           // setupWithNavController(navController)
            this.setupWithNavController(navController)
        }
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(this)

    }

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()

    @SuppressLint("ResourceType")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_html -> {
                val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
                navController.addOnDestinationChangedListener{ _, destination, _ ->
                    if (destination.id == R.id.html){
                        return@addOnDestinationChangedListener
                    }
                    else {
                        //val action = LaTexD.htmlToLaTex()
                        val action = LaTexDirections.actionLatexToHtml()
                        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
                        navController.navigate(action)
                    }
                }
                return true
            }
            R.id.navigation_latex -> {
                //val action = .actionHtmlToAddMarkdown()
               // val action = MarkdownFragmentDirections.htmlToLaTex()
                val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
                navController.addOnDestinationChangedListener{ _, destination, _ ->
                    if (destination.id == R.id.laTex){
                        return@addOnDestinationChangedListener
                    }
                    else {
                        val action = MarkdownFragmentDirections.htmlToLaTex()
                        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
                        navController.navigate(action)
                    }
                }
                //val navController = Navigation.findNavController(requireView())
                 //navController.navigate(action)
                // Respond to navigation item 2 click
                return true
            }
            else -> return false

        }
        return true
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}