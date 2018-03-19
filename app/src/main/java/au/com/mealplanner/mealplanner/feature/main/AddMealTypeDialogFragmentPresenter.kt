package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.data.model.MealType
import au.com.mealplanner.mealplanner.data.model.PlannedMeal
import io.reactivex.Flowable

class AddMealTypeDialogFragmentPresenter(private var plannedMealRepository: PlannedMealRepository,
                                         private var scheduler: MealPlannerScheduler) : BasePresenter<AddMealTypeView>() {
    fun savePlannedMeal(meal: Meal, dayOfWeek: DayOfWeek, mealType: MealType) {
        Flowable.fromCallable {
            plannedMealRepository.insert(PlannedMeal(meal.id!!, dayOfWeek.name, mealType.name))
        }.subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe( {
                    getView()?.updateWeeklyPlanView()
                }, {

                })
    }

}