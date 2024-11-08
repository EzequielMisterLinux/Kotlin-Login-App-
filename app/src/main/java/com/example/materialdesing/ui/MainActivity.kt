package com.example.materialdesing.ui


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.materialdesing.R
import com.example.materialdesing.fragments.AboutFragment
import com.example.materialdesing.fragments.HomeFragment
import com.example.materialdesing.fragments.SettingsFragment
import com.example.materialdesing.fragments.ShareFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,
            R.string.app_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_home ->supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()


            R.id.nav_ajustes ->supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment()).commit()



            R.id.nav_compartir ->supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareFragment()).commit()


            R.id.nav_info ->supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutFragment()).commit()

            R.id.nav_salir -> {Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, loginactivity::class.java)
                startActivity(intent)
            finish()}

        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}