package au.com.mealplanner.mealplanner.addMeal

import au.com.mealplanner.mealplanner.base.BasePresenter

class AddMealPresenter : BasePresenter<AddMealView>() {
    enum class MealTypes {
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK
    }

    fun setUpMealTypes() {
        val values = MealTypes.values()
        getView()?.setUpMealTypeSpinner(values)
    }

}