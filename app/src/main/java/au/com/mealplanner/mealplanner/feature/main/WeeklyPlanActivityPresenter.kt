package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.base.BasePresenter
import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.DayOfWeek.*

class WeeklyPlanActivityPresenter(private var plannedMealRepository: PlannedMealRepository,
                                  private var scheduler: MealPlannerScheduler) : BasePresenter<WeeklyPlanView>() {
    val dayOfWeekList: ArrayList<DayOfWeek> = arrayListOf(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY)

    fun goToAddMealActivity(dayOfWeek: DayOfWeek) {
        getView()?.goToAddMeal(dayOfWeek)
    }

    fun getAllPlannedMeals() {
        plannedMealRepository.getPlannedMeals()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe( {
                    plannedMeals ->
                        getView()?.updateWeeklyMealPlan(plannedMeals)
                }, {
                        getView()?.showError()
                })
    }

}