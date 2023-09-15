package com.movie.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ResultsCatsModel(
    var `data`: List<CatsModel>?
)

@Entity(tableName = "catsmodel")
data class CatsModel(
    @PrimaryKey(autoGenerate = true) var id_key: Int?,
    @ColumnInfo(name = "account_id") var account_id: Int?,
    @ColumnInfo(name = "account_url") var account_url: String?,
    @ColumnInfo(name = "ad_type") var ad_type: Int?,
    @ColumnInfo(name = "ad_url") var ad_url: String?,
    @ColumnInfo(name = "comment_count") var comment_count: Int?,
    @ColumnInfo(name = "cover") var cover: String?,
    @ColumnInfo(name = "cover_height") var cover_height: Int?,
    @ColumnInfo(name = "cover_width") var cover_width: Int?,
    @ColumnInfo(name = "datetime") var datetime: Int?,
    @ColumnInfo(name = "downs") var downs: Int?,
    @ColumnInfo(name = "favorite") var favorite: Boolean?,
    @ColumnInfo(name = "favorite_count") var favorite_count: Int?,
    @ColumnInfo(name = "id") var id: String?,
    @ColumnInfo(name = "images") var images: List<Image>?,
    @ColumnInfo(name = "images_count") var images_count: Int?,
    @ColumnInfo(name = "in_gallery") var in_gallery: Boolean?,
    @ColumnInfo(name = "in_most_viral") var in_most_viral: Boolean?,
    @ColumnInfo(name = "include_album_ads") var include_album_ads: Boolean?,
    @ColumnInfo(name = "is_ad") var is_ad: Boolean?,
    @ColumnInfo(name = "is_album") var is_album: Boolean?,
    @ColumnInfo(name = "layout") var layout: String?,
    @ColumnInfo(name = "link") var link: String?,
    @ColumnInfo(name = "nsfw") var nsfw: Boolean?,
    @ColumnInfo(name = "points") var points: Int?,
    @ColumnInfo(name = "privacy") var privacy: String?,
    @ColumnInfo(name = "score") var score: Int?,
    @ColumnInfo(name = "section") var section: String?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "ups") var ups: Int?,
    @ColumnInfo(name = "views") var views: Int?
)

data class Image(
    var ad_type: Int?,
    var ad_url: String?,
    var animated: Boolean?,
    var bandwidth: Long?,
    var datetime: Int?,
    var description: String?,
    var edited: String?,
    var favorite: Boolean?,
    var gifv: String?,
    var has_sound: Boolean?,
    var height: Int?,
    var hls: String?,
    var id: String?,
    var in_gallery: Boolean?,
    var in_most_viral: Boolean?,
    var is_ad: Boolean?,
    var link: String?,
    var looping: Boolean?,
    var mp4: String?,
    var mp4_size: Int?,
    var size: Int?,
    var type: String?,
    var views: Int?,
    var width: Int?
)