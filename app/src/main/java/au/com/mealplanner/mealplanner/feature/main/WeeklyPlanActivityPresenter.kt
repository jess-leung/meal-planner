package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.base.BasePresenter

class WeeklyPlanActivityPresenter : BasePresenter<WeeklyPlanView>() {
    fun goToAddMealActivity() {
        getView()?.goToAddMeal()
    }
}