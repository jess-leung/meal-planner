package au.com.mealplanner.mealplanner.data.model

import au.com.mealplanner.mealplanner.feature.addMeal.AddMealPresenter.MealType

data class Meal(
        val mealName: String,
        val mealType: MealType
)