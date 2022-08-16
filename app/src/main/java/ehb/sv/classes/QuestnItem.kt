package ehb.sv.classes

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestnItem (
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val question: String,
    val regions: List<String> ,
    val tags: List<String>,
    val type: String
) : Parcelable

