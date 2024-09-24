package com.cats.ui.cats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cats.R
import com.cats.databinding.FragmentCatBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatFragment : Fragment() {

    private val catViewModel: CatViewModel by viewModel()
    private lateinit var fragmentCatsBinding: FragmentCatBinding
    private val catsAdapter = CatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCatsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cat, container, false)
        startDataBindingViewModel()
        startDataBindingLiveData()
        startRecyclerView()
        startObserveListCats()
        startSearchView()
        return fragmentCatsBinding.root
    }

    private fun startDataBindingViewModel() {
        fragmentCatsBinding.catviewmodel = catViewModel
    }

    private fun startDataBindingLiveData() {
        fragmentCatsBinding.lifecycleOwner = viewLifecycleOwner
    }

    private fun startRecyclerView() {
        fragmentCatsBinding.recyclerview.setHasFixedSize(true)
        fragmentCatsBinding.recyclerview.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentCatsBinding.recyclerview.adapter = catsAdapter
    }

    private fun startObserveListCats() {
        catViewModel.filteredListMovie.observe(
            viewLifecycleOwner
        ) {
            it?.let {
                catsAdapter.submitList(it)
            }
        }
    }

    private fun startSearchView() {
        fragmentCatsBinding.searchview.setOnQueryTextListener(
            object :
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        catViewModel.setSearchQuery(it)
                        startRecyclerViewScrollPositionTop()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        catViewModel.setSearchQuery(it)
                        startRecyclerViewScrollPositionTop()
                    }
                    return false
                }
            })
    }

    private fun startRecyclerViewScrollPositionTop() {
        fragmentCatsBinding.recyclerview.scrollToPosition(
            0
        )
    }
}