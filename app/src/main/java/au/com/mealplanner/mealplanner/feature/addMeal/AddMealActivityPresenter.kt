package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.Meal
import io.reactivex.Maybe

class AddMealActivityPresenter(private var mealRepository: MealRepository,
                               private var scheduler: MealPlannerScheduler) : BasePresenter<AddMealView>() {


    fun onConfirmAddMeal(mealName: String, dayOfWeek: DayOfWeek) {
        if (mealName.isEmpty()) {
            getView()?.showError()
        } else {
            val meal = Meal(mealName)
            Maybe.fromCallable {
                mealRepository.insert(meal)
            }.observeOn(scheduler.ui()).subscribeOn(scheduler.io())
                    .subscribe({ mealId ->
                        meal.id = mealId.toInt()
                        getView()?.goToMealPlanWithNewMeal(meal, dayOfWeek)
                    }, {
                        getView()?.showError()
                    })
        }
    }
}
