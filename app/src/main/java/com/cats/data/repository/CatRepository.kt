package com.cats.data.repository

import android.util.Log
import com.cats.BuildConfig
import com.cats.data.mapper.CatMapper
import com.cats.data.source.local.db.dao.CatDao
import com.cats.data.source.local.db.entities.CatEntity
import com.cats.data.source.remote.api.CatService
import com.cats.domain.repository.CatRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CatRepository(
    private val catDao: CatDao,
    private val catService: CatService
) : CatRepositoryInterface {

    override fun getAllCats(): Flow<List<CatEntity>>? {
        return catDao.getAllCats()
    }

    private suspend fun insertCats(cats: List<CatEntity>) {
        catDao.insertCats(cats)
    }

    private suspend fun clearCats() {
        catDao.clearAllCats()
    }

    override suspend fun downloadCatsFromApi() {
        withContext(Dispatchers.IO) {
            try {
                Log.d("CatsApi", "Iniciando download de gatos...")
                val response = catService.getListCats(BuildConfig.AUTHORIZATION)

                if (response.isSuccessful) {
                    val results = response.body()
                    results?.data?.let { listCats ->
                        clearCats()
                        val catEntities = CatMapper.mapToEntityList(listCats)
                        insertCats(catEntities)
                        Log.d("CatsApi", "Inserção concluída com sucesso.")
                    }
                } else {
                    Log.e("CatsApi", "Erro: ${response.code()}, Mensagem: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CatsApi", "Erro ao buscar gatos: ${e.message}", e)
            }
        }
    }
}