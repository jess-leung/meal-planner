package au.com.mealplanner.mealplanner.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.model.Meal

@Database(entities = arrayOf(Meal::class), version = 1)
    abstract class MealPlannerDatabase : RoomDatabase() {

    abstract fun getMealDao(): MealDao

}