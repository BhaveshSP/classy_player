package com.bhaveshsp.classyplayer

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class HomeActivity : AppCompatActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
//        toolbar.setNavigationIcon(R.drawable.nav_drawer_icon)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)

//        drawerToggle.setToolbarNavigationClickListener {
//            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
//
//        }
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_videos,
            R.id.nav_music
        ).setOpenableLayout(drawerLayout).build()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        val navController = Navigation.findNavController(this,R.id.nav_host_fragment_main)
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
        NavigationUI.setupWithNavController(navigationView,navController)
        bottomNavigationView.setupWithNavController(navController)


        drawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)
        drawerToggle.isDrawerIndicatorEnabled = false
        val drawerDrawable : Drawable = ResourcesCompat.getDrawable(resources,R.drawable.nav_drawer_icon,this.theme)!!
        drawerToggle.setHomeAsUpIndicator(drawerDrawable)

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar_menu,menu)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment_main)
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp()
    }


}



