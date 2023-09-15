package com.movie.data.repository

import com.movie.data.db.dao.CatsDao
import com.movie.data.model.CatsModel
import com.movie.data.remote.service.CatsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CatsRepository(private val catsDao: CatsDao, private val catsService: CatsService) : CatsRepositoryInterface {

    private fun allCats(): CatsModel? {
        return catsDao.allCats()
    }

    override fun listCats(): Flow<List<CatsModel>>? {
        return catsDao.listCats()
    }

    private fun insertCats(catsModel: List<CatsModel>?) {
        catsDao.insertCats(catsModel)
    }

    private fun updateCats(catsModel: List<CatsModel>?) {
        catsDao.updateCats(catsModel)
    }

    override suspend fun startDownloadApiCats() {

        withContext(Dispatchers.IO) {
            val listCats: MutableList<CatsModel>? =
                catsService.getListCats(AUTHORIZATION).data as MutableList<CatsModel>?
            if (allCats() == null) {
                insertCats(listCats)
            } else {
                updateCats(listCats)
            }
        }
    }

    companion object {
        private const val AUTHORIZATION = "Client-ID 1ceddedc03a5d71"
    }
}