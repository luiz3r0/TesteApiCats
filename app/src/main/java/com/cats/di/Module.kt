package com.cats.di

import androidx.room.Room
import com.cats.data.source.local.db.database.CatDatabase
import com.cats.data.source.remote.retrofit.HttpClientRetrofit
import com.cats.data.source.remote.retrofit.HttpClientRetrofitInterface
import com.cats.data.source.remote.api.CatService
import com.cats.data.repository.*
import com.cats.domain.repository.CatRepositoryInterface
import com.cats.domain.usacase.CatUseCase
import com.cats.domain.usacase.CatUseCaseInterface
import com.cats.ui.cats.CatViewModel
import com.cats.util.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Module = module {

    single<HttpClientRetrofitInterface> { HttpClientRetrofit(androidApplication = androidApplication()) }
    single { get<HttpClientRetrofitInterface>().startRetrofit(CatService::class.java) }
    single {
        Room.databaseBuilder(
            androidContext(),
            CatDatabase::class.java,
            "catsdatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<CatDatabase>().catDao }
    factory<CatRepositoryInterface> {
        CatRepository(get(), get())
    }
    factory<SearchCatTitleUtilInterface> {
        SearchCatTitleUtil()
    }
    factory<CatUseCaseInterface> { CatUseCase(get()) }
    viewModel { CatViewModel(get(), get()) }
}