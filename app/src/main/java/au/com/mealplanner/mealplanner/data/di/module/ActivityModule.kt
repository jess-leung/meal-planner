package au.com.mealplanner.mealplanner.data.di.module

import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealPresenter
import au.com.mealplanner.mealplanner.feature.main.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module()
class ActivityModule {

    @Provides
    fun providesMealPlannerScheduler(): MealPlannerScheduler {
        return MealPlannerScheduler()
    }

    @Provides
    fun providesMainActivityPresenter(): MainActivityPresenter {
        return MainActivityPresenter()
    }

    @Provides
    fun providesAddMealPresenter(mealRepository: MealRepository, mealPlannerScheduler: MealPlannerScheduler): AddMealPresenter {
        return AddMealPresenter(mealRepository, mealPlannerScheduler)
    }

}