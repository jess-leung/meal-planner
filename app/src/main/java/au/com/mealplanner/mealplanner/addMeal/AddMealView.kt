package au.com.mealplanner.mealplanner.addMeal

import au.com.mealplanner.mealplanner.base.BaseView

interface AddMealView : BaseView {
    fun setUpMealTypeSpinner(values: Array<AddMealPresenter.MealTypes>)
}