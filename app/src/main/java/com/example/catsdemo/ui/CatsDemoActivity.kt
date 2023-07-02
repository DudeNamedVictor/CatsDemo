package com.example.catsdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.catsdemo.R
import com.example.catsdemo.databinding.CatsDemoLayoutBinding
import com.google.android.material.navigation.NavigationBarView

class CatsDemoActivity : AppCompatActivity() {

    private var _binding: CatsDemoLayoutBinding? = null
    private val binding: CatsDemoLayoutBinding
        get() = _binding!!

    private var catsDemoAdapter: CatsDemoAdapter? = null

    private val onNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_cats -> {
                binding.viewPager.currentItem = CATS_FRAGMENT
                supportActionBar?.title = getString(R.string.title_cats)
                return@OnItemSelectedListener true
            }

            R.id.navigation_voting -> {
                binding.viewPager.currentItem = VOTING_FRAGMENT
                supportActionBar?.title = getString(R.string.title_voting)
                return@OnItemSelectedListener true
            }

            R.id.navigation_favourites -> {
                binding.viewPager.currentItem = FAVOURITES_FRAGMENT
                supportActionBar?.title = getString(R.string.title_favourites)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = CatsDemoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViewPager()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initializeViewPager() {
        catsDemoAdapter = CatsDemoAdapter(this)
        binding.viewPager.adapter = catsDemoAdapter
        binding.navView.setOnItemSelectedListener(onNavigationItemSelectedListener)
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    CATS_FRAGMENT -> {
                        binding.navView.menu.findItem(R.id.navigation_cats).isChecked =
                            true
                        supportActionBar?.title = getString(R.string.title_cats)
                    }

                    VOTING_FRAGMENT -> {
                        binding.navView.menu.findItem(R.id.navigation_voting).isChecked =
                            true
                        supportActionBar?.title = getString(R.string.title_voting)
                    }

                    FAVOURITES_FRAGMENT -> {
                        binding.navView.menu.findItem(R.id.navigation_favourites).isChecked =
                            true
                        supportActionBar?.title = getString(R.string.title_favourites)
                    }
                }
            }
        })
    }

    companion object {
        const val CATS_FRAGMENT = 0
        const val VOTING_FRAGMENT = 1
        const val FAVOURITES_FRAGMENT = 2
    }

}