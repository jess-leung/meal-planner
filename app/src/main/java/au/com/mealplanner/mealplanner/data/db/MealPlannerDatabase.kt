package au.com.mealplanner.mealplanner.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.data.model.PlannedMeal

@Database(entities = arrayOf(Meal::class, PlannedMeal::class), version = 1)
    abstract class MealPlannerDatabase : RoomDatabase() {

    abstract fun getMealDao(): MealDao
    abstract fun getPlannedMealDao(): PlannedMealDao

}