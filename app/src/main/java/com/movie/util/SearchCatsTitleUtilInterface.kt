package com.movie.util

import androidx.lifecycle.LiveData
import com.movie.data.model.CatsModel

interface SearchCatsTitleUtilInterface {

    fun filterList(
        list: LiveData<List<CatsModel>>?, searchQuery: LiveData<CharSequence>
    ): LiveData<List<CatsModel>>
}
