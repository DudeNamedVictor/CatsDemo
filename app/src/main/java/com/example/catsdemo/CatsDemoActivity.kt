package com.example.catsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catsdemo.databinding.CatsDemoLayoutBinding

class CatsDemoActivity : AppCompatActivity() {

    private var _binding: CatsDemoLayoutBinding? = null
    private val binding: CatsDemoLayoutBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = CatsDemoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}