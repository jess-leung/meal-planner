package au.com.mealplanner.mealplanner.feature.viewMeals

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository

class ViewMealsActivityPresenter(var mealRepository: MealRepository, var scheduler: MealPlannerScheduler) : BasePresenter<ViewMealView>() {
    fun getMeals() {
        mealRepository.fetchAll()
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe({ mealList ->
                    getView()?.showMealList(mealList)
                }, {
                    getView()?.showError()
                })
    }
}
