package au.com.mealplanner.mealplanner.data.module

import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import au.com.mealplanner.mealplanner.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeAddMealActivity(): AddMealActivity

}