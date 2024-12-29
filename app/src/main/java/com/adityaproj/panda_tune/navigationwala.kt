package com.adityaproj.panda_tune

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.adityaproj.panda_tune.databinding.ActivityNavigationwalaBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class navigationwala : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationwalaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityNavigationwalaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar
        setSupportActionBar(binding.appBarNavigationwala.toolbar)

        // Floating action button
        binding.appBarNavigationwala.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        // Set up Navigation Drawer
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigationwala)

        // Configure top-level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Initialize ImageSlider
        val imageSlider = findViewById<ImageSlider>(R.id.imagewa)
        val imageList = ArrayList<SlideModel>()

        // Adding images to the slider
        imageList.add(SlideModel(R.drawable.husn, "Banger from Tamannaah"))
        imageList.add(SlideModel(R.drawable.ranveer, "Another Level"))
        imageList.add(SlideModel(R.drawable.payal, "King Honey"))

        imageSlider.setImageList(imageList)

        // Set up button click listeners
        val hindi = findViewById<ImageButton>(R.id.bolly)
        hindi.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        val eminem = findViewById<ImageButton>(R.id.emi)
        eminem.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigationwala, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigationwala)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
