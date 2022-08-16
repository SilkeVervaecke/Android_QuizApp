package ehb.sv.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") val name: String = "Joske",
    @ColumnInfo(name = "score") val score: Int = 0,
    @ColumnInfo(name = "quest_correct") val questCorrect: Int = 0,
    @ColumnInfo(name = "quest_wrong") val questWrong: Int = 0,

)

