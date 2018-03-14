package au.com.mealplanner.mealplanner.data.db.repository

import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.model.Meal

class MealRepository(private var mealDao: MealDao) {

    fun insert(meal: Meal) {
        return mealDao.insert(meal)
    }
}