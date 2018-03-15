package au.com.mealplanner.mealplanner.data.di.module

import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class ))
    abstract fun contributeWeeklyPlanActivity(): WeeklyPlanActivity

    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class ))
    abstract fun contributeAddMealActivity(): AddMealActivity

}