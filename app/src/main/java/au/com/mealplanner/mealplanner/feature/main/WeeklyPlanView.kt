package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.data.model.DayOfWeek

interface WeeklyPlanView {
    fun goToAddMeal(dayOfWeek: DayOfWeek)
    fun updateWeeklyMealPlan(plannedMeals: List<PlannedMealDao.PlannedMealWithMeal>)
    fun setUpWeeklyPlanView()
}