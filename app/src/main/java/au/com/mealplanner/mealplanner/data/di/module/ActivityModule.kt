package au.com.mealplanner.mealplanner.data.di.module

import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivityPresenter
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanActivityPresenter
import dagger.Module
import dagger.Provides

@Module()
class ActivityModule {

    @Provides
    fun providesMealPlannerScheduler(): MealPlannerScheduler {
        return MealPlannerScheduler()
    }

    @Provides
    fun providesWeeklyPlanActivityPresenter(): WeeklyPlanActivityPresenter {
        return WeeklyPlanActivityPresenter()
    }

    @Provides
    fun providesAddMealActivityPresenter(mealRepository: MealRepository, mealPlannerScheduler: MealPlannerScheduler): AddMealActivityPresenter {
        return AddMealActivityPresenter(mealRepository, mealPlannerScheduler)
    }

}