package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.model.DayOfWeek

class WeeklyPlanActivityPresenter : BasePresenter<WeeklyPlanView>() {
    fun goToAddMealActivity(dayOfWeek: DayOfWeek) {
        getView()?.goToAddMeal(dayOfWeek)
    }
}