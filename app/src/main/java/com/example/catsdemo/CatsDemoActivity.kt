package com.example.catsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.catsdemo.databinding.CatsDemoLayoutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CatsDemoActivity : AppCompatActivity() {

    private var _binding: CatsDemoLayoutBinding? = null
    private val binding: CatsDemoLayoutBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = CatsDemoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        initializeNavigationView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initializeNavigationView() {
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentActivityMain) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_cats, R.id.navigation_voting, R.id.navigation_favourites
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}