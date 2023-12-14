package com.demo.quoteabletest.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Result(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var _id: String,
    var author: String,
    var authorSlug: String,
    var content: String,
    var dateAdded: String,
    var dateModified: String,
    var length: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(author)
        parcel.writeString(authorSlug)
        parcel.writeString(content)
        parcel.writeString(dateAdded)
        parcel.writeString(dateModified)
        parcel.writeInt(length)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }

}