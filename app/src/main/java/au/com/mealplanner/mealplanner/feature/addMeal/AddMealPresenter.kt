package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.model.Meal
import io.reactivex.Maybe

class AddMealPresenter(private var mealRepository: MealRepository,
                       private var scheduler: MealPlannerScheduler) : BasePresenter<AddMealView>() {

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
            val meal = Meal(mealName)
            Maybe.fromCallable {
                mealRepository.insert(meal)
            }.observeOn(scheduler.ui()).subscribeOn(scheduler.io())
                    .subscribe({
                        getView()?.goToMealPlanWithNewMeal(meal)
                    }, {
                        getView()?.showError()
                    })
        }
    }
}
