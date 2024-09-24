package com.cats.data.source.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cats.data.model.ImageModel

@Entity(tableName = "catmodel")
data class CatEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "cat_id") val id: Int? = null,
    @ColumnInfo(name = "account_id") val accountId: Int?,
    @ColumnInfo(name = "account_url") val accountUrl: String?,
    @ColumnInfo(name = "ad_type") val adType: Int?,
    @ColumnInfo(name = "ad_url") val adUrl: String?,
    @ColumnInfo(name = "comment_count") val commentCount: Int?,
    @ColumnInfo(name = "cover") val cover: String?,
    @ColumnInfo(name = "cover_height") val coverHeight: Int?,
    @ColumnInfo(name = "cover_width") val coverWidth: Int?,
    @ColumnInfo(name = "datetime") val datetime: Int?,
    @ColumnInfo(name = "downs") val downs: Int?,
    @ColumnInfo(name = "favorite") val favorite: Boolean?,
    @ColumnInfo(name = "favorite_count") val favoriteCount: Int?,
    @ColumnInfo(name = "id") val idStr: String?,
    @ColumnInfo(name = "images") val images: List<ImageModel>?,
    @ColumnInfo(name = "images_count") val imagesCount: Int?,
    @ColumnInfo(name = "in_gallery") val inGallery: Boolean?,
    @ColumnInfo(name = "in_most_viral") val inMostViral: Boolean?,
    @ColumnInfo(name = "include_album_ads") val includeAlbumAds: Boolean?,
    @ColumnInfo(name = "is_ad") val isAd: Boolean?,
    @ColumnInfo(name = "is_album") val isAlbum: Boolean?,
    @ColumnInfo(name = "layout") val layout: String?,
    @ColumnInfo(name = "link") val link: String?,
    @ColumnInfo(name = "nsfw") val nsfw: Boolean?,
    @ColumnInfo(name = "points") val points: Int?,
    @ColumnInfo(name = "privacy") val privacy: String?,
    @ColumnInfo(name = "score") val score: Int?,
    @ColumnInfo(name = "section") val section: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "ups") val ups: Int?,
    @ColumnInfo(name = "views") val views: Int?
)
