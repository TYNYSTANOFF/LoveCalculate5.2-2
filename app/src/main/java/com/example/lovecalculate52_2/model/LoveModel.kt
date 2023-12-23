package com.example.lovecalculate52_2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstName : String,

    @SerializedName("sname")
    var secondName : String,

//    @SerializedName("percentage")
    var percentage : String,

//    @SerializedName("result")
    var result : String,

    @PrimaryKey(autoGenerate = true)
    var id :Int

): Serializable
