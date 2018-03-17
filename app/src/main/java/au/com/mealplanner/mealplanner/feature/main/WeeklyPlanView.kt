package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.data.model.DayOfWeek

interface WeeklyPlanView {
    fun goToAddMeal(dayOfWeek: DayOfWeek)
}