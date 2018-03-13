package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.base.BaseView
import au.com.mealplanner.mealplanner.data.model.Meal

interface AddMealView : BaseView {
    fun showError()
    fun saveMealToDatabase(meal: Meal)
}