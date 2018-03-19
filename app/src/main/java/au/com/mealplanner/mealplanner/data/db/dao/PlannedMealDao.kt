package au.com.mealplanner.mealplanner.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import au.com.mealplanner.mealplanner.data.model.PlannedMeal
import io.reactivex.Flowable

@Dao
interface PlannedMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(meal: PlannedMeal)

    @Query("SELECT Meal.meal_name, PlannedMeal.day_of_week, PlannedMeal.meal_type FROM PlannedMeal INNER JOIN Meal ON Meal.id = PlannedMeal.meal_id")
    fun getPlannedMealsGivenDayOfWeek(): Flowable<List<PlannedMealWithMeal>>

    class PlannedMealWithMeal {
        lateinit var meal_name: String
        lateinit var day_of_week: String
        lateinit var meal_type: String
    }

}
