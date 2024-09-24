package com.cats.ui.cats

import androidx.lifecycle.*
import com.cats.data.mapper.CatMapper
import com.cats.data.model.CatModel
import com.cats.data.source.local.db.entities.CatEntity
import com.cats.domain.usacase.CatUseCaseInterface
import com.cats.util.SearchCatTitleUtilInterface
import kotlinx.coroutines.launch

class CatViewModel(
    searchCatTitleUtilInterface: SearchCatTitleUtilInterface,
    private val catUseCaseInterface: CatUseCaseInterface
) : ViewModel() {

    private val _dataRoomListCats = MediatorLiveData<List<CatModel>>()
    private val dataRoomListCats: LiveData<List<CatModel>>
        get() = _dataRoomListCats

    private val _searchQuery = MutableLiveData<CharSequence>("")
    private val searchQuery: LiveData<CharSequence>
        get() = _searchQuery

    val filteredListMovie: LiveData<List<CatModel>> =
        searchCatTitleUtilInterface.filterList(dataRoomListCats, searchQuery)

    fun setSearchQuery(query: CharSequence?) {
        query?.let {
            _searchQuery.value = it
        }
    }

    init {
        startDownloadCatsFromApi()
        observeCats()
    }

    private fun observeCats() {
        val source: LiveData<List<CatEntity>> = catUseCaseInterface.getCats()?.asLiveData() ?: MutableLiveData()
        source.observeForever { catEntities ->
            _dataRoomListCats.value = catEntities?.let { CatMapper.mapToModelList(it) } ?: emptyList()
        }
    }

    private fun startDownloadCatsFromApi() {
        viewModelScope.launch {
            catUseCaseInterface.downloadCatsFromApi()
        }
    }
}