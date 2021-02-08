package com.example.kotlinflow.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity
class  Music(){
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0


    @SerializedName("itune")
    var itune : List<Itunes> ?= arrayListOf()
        get() = field
        set(value) {field = value}
}

data class Itunes(
            @PrimaryKey
            @SerializedName("itune_id")
            var itune_id: Int = 0,

            @SerializedName("uniqueID")
            var uniqueID:String,

            @SerializedName("ProduktID")
            var produktID:String ,

            @SerializedName("Type")
            var type: String,

            @SerializedName("Kategorie")
            var kategorie:String,

            @SerializedName("ShortName")
            var shortName:String,

            @SerializedName("FolgeNo")
            var folgeNo:String,

            @SerializedName("FolgeNoRef")
            var folgeNoRef:String,

            @SerializedName("ReleaseDate")
            var releaseDate:String,
            @SerializedName("Artist")
            var artist:String,
            @SerializedName("Title")
            var title:String,
            @SerializedName("InfoText")
            var infoText:String,
            @SerializedName("Sprecher")
            var sprecher:String,
            @SerializedName("AutorScript")
            var autorScript:String,
            @SerializedName("AutorBuch")
            var autorBuch:String,
            @SerializedName("RegProduction")
            var regProduction:String,
            @SerializedName("Cover")
            var cover:String ,
            @SerializedName("Link1")
            var link1:String,
            @SerializedName("Link2")
            var link2:String,
            @SerializedName("Preview")
            var preview:String,
            @SerializedName("ThumbURL")
            var thumbURL:String,
            @SerializedName("CoverImgURL")
            var coverImgURL:String,
            @SerializedName("AudioMP3")
            var audioMP3:String
            )
