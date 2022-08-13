package ehb.sv.classes

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

data class QuestnItem (
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val question: String,
    val regions: List<Any>,
    val tags: List<String>,
    val type: String
)
//    : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.createStringArrayList()!!,
//        parcel.readString().toString(),
//        parcel.readArray(),
//        parcel.createStringArrayList()!!,
//        parcel.readString().toString()
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(category)
//        parcel.writeString(correctAnswer)
//        parcel.writeString(difficulty)
//        parcel.writeString(id)
//        parcel.writeStringList(incorrectAnswers)
//        parcel.writeString(question)
//        parcel.writeStringList(tags)
//        parcel.writeString(type)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<QuestnItem> {
//        override fun createFromParcel(parcel: Parcel): QuestnItem {
//            return QuestnItem(parcel)
//        }
//
//        override fun newArray(size: Int): Array<QuestnItem?> {
//            return arrayOfNulls(size)
//        }
//    }
//}