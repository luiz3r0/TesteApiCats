package com.cats.data.model


data class CatResponse(
    val data: List<CatModel>?
)

data class CatModel(
    val accountId: Int?,
    val accountUrl: String?,
    val adType: Int?,
    val adUrl: String?,
    val commentCount: Int?,
    val cover: String?,
    val coverHeight: Int?,
    val coverWidth: Int?,
    val datetime: Int?,
    val downs: Int?,
    val favorite: Boolean?,
    val favoriteCount: Int?,
    val id: String?,
    val images: List<ImageModel>?,
    val imagesCount: Int?,
    val inGallery: Boolean?,
    val inMostViral: Boolean?,
    val includeAlbumAds: Boolean?,
    val isAd: Boolean?,
    val isAlbum: Boolean?,
    val layout: String?,
    val link: String?,
    val nsfw: Boolean?,
    val points: Int?,
    val privacy: String?,
    val score: Int?,
    val section: String?,
    val title: String?,
    val ups: Int?,
    val views: Int?
)

data class ImageModel(
    val adType: Int?,
    val adUrl: String?,
    val animated: Boolean?,
    val bandwidth: Long?,
    val datetime: Int?,
    val description: String?,
    val edited: String?,
    val favorite: Boolean?,
    val gifv: String?,
    val hasSound: Boolean?,
    val height: Int?,
    val hls: String?,
    val id: String?,
    val inGallery: Boolean?,
    val inMostViral: Boolean?,
    val isAd: Boolean?,
    val link: String?,
    val looping: Boolean?,
    val mp4: String?,
    val mp4Size: Int?,
    val size: Int?,
    val type: String?,
    val views: Int?,
    val width: Int?
)