package au.com.mealplanner.mealplanner.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Meal(
        @ColumnInfo(name = "meal_name") var mealName: String = ""
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}