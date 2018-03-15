package au.com.mealplanner.mealplanner.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import au.com.mealplanner.mealplanner.data.model.Meal


@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(meal: Meal)
}