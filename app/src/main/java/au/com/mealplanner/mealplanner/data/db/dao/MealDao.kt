package au.com.mealplanner.mealplanner.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import au.com.mealplanner.mealplanner.data.model.Meal
import io.reactivex.Flowable

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(meal: Meal): Long

    @Query("SELECT * from meal")
    fun fetchAll(): Flowable<List<Meal>>
}