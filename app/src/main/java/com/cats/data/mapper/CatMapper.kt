package com.cats.data.mapper

import com.cats.data.model.CatModel
import com.cats.data.source.local.db.entities.CatEntity

object CatMapper {

    private fun mapToEntity(catModel: CatModel): CatEntity {
        return CatEntity(
            id = null,
            accountId = catModel.accountId,
            accountUrl = catModel.accountUrl,
            adType = catModel.adType,
            adUrl = catModel.adUrl,
            commentCount = catModel.commentCount,
            cover = catModel.cover,
            coverHeight = catModel.coverHeight,
            coverWidth = catModel.coverWidth,
            datetime = catModel.datetime,
            downs = catModel.downs,
            favorite = catModel.favorite,
            favoriteCount = catModel.favoriteCount,
            idStr = catModel.id,
            images = catModel.images,
            imagesCount = catModel.imagesCount,
            inGallery = catModel.inGallery,
            inMostViral = catModel.inMostViral,
            includeAlbumAds = catModel.includeAlbumAds,
            isAd = catModel.isAd,
            isAlbum = catModel.isAlbum,
            layout = catModel.layout,
            link = catModel.link,
            nsfw = catModel.nsfw,
            points = catModel.points,
            privacy = catModel.privacy,
            score = catModel.score,
            section = catModel.section,
            title = catModel.title,
            ups = catModel.ups,
            views = catModel.views
        )
    }

    fun mapToEntityList(catModels: List<CatModel>?): List<CatEntity> {
        return catModels?.map { mapToEntity(it) } ?: emptyList()
    }

    private fun mapToModel(catEntity: CatEntity): CatModel {
        return CatModel(
            accountId = catEntity.accountId,
            accountUrl = catEntity.accountUrl,
            adType = catEntity.adType,
            adUrl = catEntity.adUrl,
            commentCount = catEntity.commentCount,
            cover = catEntity.cover,
            coverHeight = catEntity.coverHeight,
            coverWidth = catEntity.coverWidth,
            datetime = catEntity.datetime,
            downs = catEntity.downs,
            favorite = catEntity.favorite,
            favoriteCount = catEntity.favoriteCount,
            id = catEntity.idStr,
            images = catEntity.images,
            imagesCount = catEntity.imagesCount,
            inGallery = catEntity.inGallery,
            inMostViral = catEntity.inMostViral,
            includeAlbumAds = catEntity.includeAlbumAds,
            isAd = catEntity.isAd,
            isAlbum = catEntity.isAlbum,
            layout = catEntity.layout,
            link = catEntity.link,
            nsfw = catEntity.nsfw,
            points = catEntity.points,
            privacy = catEntity.privacy,
            score = catEntity.score,
            section = catEntity.section,
            title = catEntity.title,
            ups = catEntity.ups,
            views = catEntity.views
        )
    }

    fun mapToModelList(catEntities: List<CatEntity>?): List<CatModel> {
        return catEntities?.map { mapToModel(it) } ?: emptyList()
    }
}