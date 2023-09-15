package com.movie.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.map
import com.movie.data.model.CatsModel

class SearchCatsTitleUtil: SearchCatsTitleUtilInterface {
    override fun filterList(
        list: LiveData<List<CatsModel>>?,
        searchQuery: LiveData<CharSequence>
    ): LiveData<List<CatsModel>> =
        Transformations.switchMap(searchQuery) {
            list?.map { list ->
                searchQuery.value?.let {
                    list.filter { galleryShopsServices ->
                        val query = searchQuery.value.toString()
                        with(galleryShopsServices) {
                            applyQuery(query)
                        }
                    }
                }
            }
        }

    private fun CatsModel.applyQuery(query: String) =
        title?.contains(query, true) == true
}
