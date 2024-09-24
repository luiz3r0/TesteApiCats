package com.cats.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cats.data.model.CatModel

class SearchCatTitleUtil : SearchCatTitleUtilInterface {
    override fun filterList(
        list: LiveData<List<CatModel>>?,
        searchQuery: LiveData<CharSequence>
    ): LiveData<List<CatModel>> {
        val result = MutableLiveData<List<CatModel>>()

        list?.observeForever { cats ->
            val queryText = searchQuery.value?.toString()?.trim() ?: ""
            result.value = if (queryText.isEmpty()) {
                cats
            } else {
                cats.filter { it.title?.contains(queryText, ignoreCase = true) == true }
            }
        }

        searchQuery.observeForever { newQuery ->
            list?.value?.let { cats ->
                val queryText = newQuery?.toString()?.trim() ?: ""
                result.value = if (queryText.isEmpty()) {
                    cats
                } else {
                    cats.filter { it.title?.contains(queryText, ignoreCase = true) == true }
                }
            }
        }

        return result
    }
}
