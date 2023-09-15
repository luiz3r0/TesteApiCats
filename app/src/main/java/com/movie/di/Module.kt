package com.movie.di

import com.movie.data.db.database.CatsDatabase
import com.movie.data.remote.retrofit.HttpClientRetrofit
import com.movie.data.remote.retrofit.HttpClientRetrofitInterface
import com.movie.data.remote.service.CatsService
import com.movie.data.repository.*
import com.movie.ui.cats.CatsViewModel
import com.movie.util.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Module = module {

    factory<HttpClientRetrofitInterface> { HttpClientRetrofit(androidApplication = androidApplication()) }
    factory { get<HttpClientRetrofitInterface>().startRetrofit(CatsService::class.java) }
    factory { CatsDatabase.getInstance(androidContext()).catsDao }
    factory<CatsRepositoryInterface> {
        CatsRepository(get(), get())
    }
    factory<GlideUtilInterface> {
        GlideUtil()
    }
    factory<SearchCatsTitleUtilInterface> {
        SearchCatsTitleUtil()
    }
    viewModel { CatsViewModel(get(), get()) }
}