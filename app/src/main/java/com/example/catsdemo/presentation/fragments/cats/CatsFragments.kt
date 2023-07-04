package com.example.catsdemo.presentation.fragments.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.catsdemo.databinding.CatsLayoutBinding
import com.example.catsdemo.presentation.MainApplication

class CatsFragments : Fragment() {

    private var _binding: CatsLayoutBinding? = null
    private val binding: CatsLayoutBinding
        get() = _binding!!

    private val viewModel: CatsViewModel by viewModels {
        CatsViewModel.CatsViewModelFactory(
            (requireActivity().application as MainApplication).appComponent.getCatsUseCase()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CatsLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}