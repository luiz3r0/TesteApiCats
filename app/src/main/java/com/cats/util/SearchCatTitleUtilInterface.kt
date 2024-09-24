package com.cats.util

import androidx.lifecycle.LiveData
import com.cats.data.model.CatModel

interface SearchCatTitleUtilInterface {

    fun filterList(
        list: LiveData<List<CatModel>>?, searchQuery: LiveData<CharSequence>
    ): LiveData<List<CatModel>>
}
