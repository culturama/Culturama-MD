package com.example.culturama.data.manager

import com.example.culturama.model.CultureDataSource
import com.example.culturama.model.FavCulture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CultureRepository {
    private val favCulture = mutableListOf<FavCulture>()

    init {
        if (favCulture.isEmpty()) {
            CultureDataSource.listCulture.forEach {
                favCulture.add(FavCulture(it))
            }
        }
    }

    fun getAllCulture(): Flow<List<FavCulture>> {
        return flowOf(favCulture)
    }

    fun getFavCultureById(cultureId: Long): FavCulture {
        return favCulture.first {
            it.culture.id == cultureId
        }
    }

    fun updateFavCulture(cultureId: Long): Flow<Boolean> {
        val index = favCulture.indexOfFirst { it.culture.id == cultureId }
        val result = if (index >= 0) {
            val favCult = favCulture[index]
            favCulture[index] =
                favCult.copy(culture = favCult.culture)
            true
        } else {
            false
        }
        return flowOf(result)
    }

//    fun getAddedFavGames(): Flow<List<FavGames>> {
//        return getAllGames()
//            .map { favGames ->
//                favGames.filter { favGame ->
//                    favGame.count != 0
//                }
//            }
//    }

    companion object {
        @Volatile
        private var instance: CultureRepository? = null

        fun getInstance(): CultureRepository =
            instance ?: synchronized(this) {
                CultureRepository().apply {
                    instance = this
                }
            }
    }
}