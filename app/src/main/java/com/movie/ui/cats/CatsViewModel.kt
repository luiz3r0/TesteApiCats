package com.movie.ui.cats

import androidx.lifecycle.*
import com.movie.data.model.CatsModel
import com.movie.data.repository.CatsRepositoryInterface
import com.movie.util.SearchCatsTitleUtilInterface
import kotlinx.coroutines.launch

class CatsViewModel(
    private val catsRepositoryInterface: CatsRepositoryInterface,
    searchCatsTitleUtilInterface: SearchCatsTitleUtilInterface
) : ViewModel() {

    private val _dataRoomListCats =
        catsRepositoryInterface.listCats()?.asLiveData() as MutableLiveData<List<CatsModel>>?
    private val dataRoomListCats: LiveData<List<CatsModel>>?
        get() = _dataRoomListCats

    private val _searchQuery = MutableLiveData<CharSequence>("")
    private val searchQuery: LiveData<CharSequence>
        get() = _searchQuery

    val filteredListMovie: LiveData<List<CatsModel>> =
        searchCatsTitleUtilInterface.filterList(dataRoomListCats, searchQuery)

    fun setSearchQuery(query: CharSequence?) {
        query?.let {
            _searchQuery.value = it
        }
    }

    init {
        startDownloadApiCats()
    }

    private fun startDownloadApiCats() {
        viewModelScope.launch {
            catsRepositoryInterface.startDownloadApiCats()
        }
    }
}