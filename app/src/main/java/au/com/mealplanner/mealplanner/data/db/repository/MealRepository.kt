package au.com.mealplanner.mealplanner.data.db.repository

import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.model.Meal

class MealRepository(mealDao: MealDao) {
    private var mealDao: MealDao = mealDao

    fun insert(meal: Meal): Long {
        return mealDao.insert(meal)
    }
}