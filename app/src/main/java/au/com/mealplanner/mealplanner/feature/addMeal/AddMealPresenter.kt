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

    fun onConfirmAddMeal(mealName: String) {
        if (mealName.isEmpty()) {
            getView()?.showError()
        } else {
          getView()?.saveMealToDatabase(Meal(mealName))
        }
    }

}