package au.com.mealplanner.mealplanner.data.di.module

import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivityPresenter
import au.com.mealplanner.mealplanner.feature.main.AddMealTypeDialogFragmentPresenter
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanActivityPresenter
import au.com.mealplanner.mealplanner.feature.viewMeals.ViewMealsActivityPresenter
import dagger.Module
import dagger.Provides

@Module()
class ActivityModule {

    @Provides
    fun providesMealPlannerScheduler(): MealPlannerScheduler {
        return MealPlannerScheduler()
    }

    @Provides
    fun providesWeeklyPlanActivityPresenter(plannedMealRepository: PlannedMealRepository, mealPlannerScheduler: MealPlannerScheduler): WeeklyPlanActivityPresenter {
        return WeeklyPlanActivityPresenter(plannedMealRepository, mealPlannerScheduler)
    }

    @Provides
    fun providesAddMealActivityPresenter(mealRepository: MealRepository, mealPlannerScheduler: MealPlannerScheduler): AddMealActivityPresenter {
        return AddMealActivityPresenter(mealRepository, mealPlannerScheduler)
    }

    @Provides
    fun providesViewMealsActivityPresenter(mealRepository: MealRepository, mealPlannerScheduler: MealPlannerScheduler): ViewMealsActivityPresenter {
        return ViewMealsActivityPresenter(mealRepository, mealPlannerScheduler)
    }

    @Provides
    fun providesAddMealTypeDialogFragmentPresenter(plannedMealRepository: PlannedMealRepository, mealPlannerScheduler: MealPlannerScheduler): AddMealTypeDialogFragmentPresenter {
        return AddMealTypeDialogFragmentPresenter(plannedMealRepository, mealPlannerScheduler)
    }

}