package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.model.Meal

class AddMealPresenter : BasePresenter<AddMealView>() {
    enum class MealType {
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK
    }

    fun setUpMealTypes() {
        val values = MealType.values()
        getView()?.setUpMealTypeSpinner(values)
    }

    fun onConfirmAddMeal(mealName: String, mealType: MealType) {
        if (mealName.isEmpty()) {
            getView()?.showError()
        } else {
          getView()?.saveMealToDatabase(Meal(mealName, mealType))
        }
    }

}