package com.example.catsdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.catsdemo.presentation.CatsDemoActivity.Companion.CATS_FRAGMENT
import com.example.catsdemo.presentation.CatsDemoActivity.Companion.FAVOURITES_FRAGMENT
import com.example.catsdemo.presentation.CatsDemoActivity.Companion.VOTING_FRAGMENT
import com.example.catsdemo.presentation.fragments.cats.CatsFragments
import com.example.catsdemo.presentation.fragments.favourites.FavouritesFragment
import com.example.catsdemo.presentation.fragments.voting.VotingFragment

class CatsDemoAdapter(appCompatActivity: AppCompatActivity) :
    FragmentStateAdapter(appCompatActivity) {
    override fun getItemCount(): Int {
        return NUMBER_OF_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            CATS_FRAGMENT -> CatsFragments()
            VOTING_FRAGMENT -> VotingFragment()
            FAVOURITES_FRAGMENT -> FavouritesFragment()
            else -> CatsFragments()
        }
    }

    companion object {
        private const val NUMBER_OF_PAGES = 3
    }

}