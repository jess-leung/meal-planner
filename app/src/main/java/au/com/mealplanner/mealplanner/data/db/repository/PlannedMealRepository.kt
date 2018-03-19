package au.com.mealplanner.mealplanner.data.db.repository

import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao.PlannedMealWithMeal
import au.com.mealplanner.mealplanner.data.model.PlannedMeal
import io.reactivex.Flowable

class PlannedMealRepository(private var plannedMealDao: PlannedMealDao) {
    fun insert(meal: PlannedMeal) {
        return plannedMealDao.insert(meal)
    }

    fun getPlannedMeals(): Flowable<List<PlannedMealWithMeal>> {
        return plannedMealDao.getPlannedMealsGivenDayOfWeek()
    }

}