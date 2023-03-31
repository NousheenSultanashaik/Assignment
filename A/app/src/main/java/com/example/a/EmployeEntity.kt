package com.example.a

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "employee-table")
data class EmployeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    @ColumnInfo(name = "Email id")
    val Emailid: String = "",

    val gender: String = "",
    val btech: String = "",
    val dob: String = "",
    val dateTime: String = "",
    val ratingme: Int = 0,
    val howdourate: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(Emailid)
        parcel.writeString(gender)
        parcel.writeString(btech)
        parcel.writeString(dob)
        parcel.writeString(dateTime)
        parcel.writeInt(ratingme)
        parcel.writeInt(howdourate)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<EmployeEntity> {
        override fun createFromParcel(parcel: Parcel): EmployeEntity {
            return EmployeEntity(parcel)
        }

        override fun newArray(size: Int): Array<EmployeEntity?> {
            return arrayOfNulls(size)
        }
    }


}