package au.com.mealplanner.mealplanner.feature.viewMeals

import au.com.mealplanner.mealplanner.data.model.Meal

interface ViewMealView {
    fun showMealList(mealList: List<Meal>)
    fun showError()
}
