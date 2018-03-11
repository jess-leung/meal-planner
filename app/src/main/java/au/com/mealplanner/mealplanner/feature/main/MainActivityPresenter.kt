package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.base.BasePresenter

class MainActivityPresenter : BasePresenter<MainView>() {
    fun goToAddMealActivity() {
        getView()?.goToAddMeal()
    }
}