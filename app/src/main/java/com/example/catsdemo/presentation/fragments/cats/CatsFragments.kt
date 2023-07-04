package com.example.catsdemo.presentation.fragments.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catsdemo.databinding.CatsLayoutBinding
import com.example.catsdemo.presentation.MainApplication
import kotlinx.coroutines.launch

class CatsFragments : Fragment() {

    private var _binding: CatsLayoutBinding? = null
    private val binding: CatsLayoutBinding
        get() = _binding!!

    private val viewModel: CatsViewModel by viewModels {
        CatsViewModel.CatsViewModelFactory(
            (requireActivity().application as MainApplication).appComponent.getCatsUseCase()
        )
    }

    private var adapter: CatsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CatsLayoutBinding.inflate(inflater, container, false)

        initRecycler()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.catsListMLD.observe(viewLifecycleOwner) {
            updateRecycler(it)
        }
    }

    private fun initRecycler() {
        adapter = CatsAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
    }

    private fun updateRecycler(list: PagingData<CatsRecyclerModel>) {
        lifecycleScope.launch {
            adapter?.submitData(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val SPAN_COUNT = 2
    }

}