package au.com.mealplanner.mealplanner.data.db.repository

import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.model.Meal
import io.reactivex.Flowable

class MealRepository(private var mealDao: MealDao) {

    fun insert(meal: Meal): Long {
        return mealDao.insert(meal)
    }

    fun fetchAll(): Flowable<List<Meal>> {
        return mealDao.fetchAll()
    }
}