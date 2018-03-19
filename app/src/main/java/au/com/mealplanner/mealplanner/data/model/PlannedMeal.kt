package au.com.mealplanner.mealplanner.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import au.com.mealplanner.mealplanner.data.model.DayOfWeek.MONDAY
import au.com.mealplanner.mealplanner.data.model.MealType.BREAKFAST

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Meal::class,
parentColumns = arrayOf("id"),
childColumns = arrayOf("meal_id"),
onDelete = ForeignKey.CASCADE)))
data class PlannedMeal (
        @ColumnInfo(name = "meal_id") var meal: Int = 0,
        @ColumnInfo(name = "day_of_week") var dayOfWeek: String = MONDAY.name,
        @ColumnInfo(name = "meal_type") var mealType: String = BREAKFAST.name
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}