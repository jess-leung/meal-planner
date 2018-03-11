package au.com.mealplanner.mealplanner.data.module

import au.com.mealplanner.mealplanner.feature.addMeal.AddMealPresenter
import au.com.mealplanner.mealplanner.feature.main.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun providesMainActivityPresenter(): MainActivityPresenter {
        return MainActivityPresenter()
    }

    @Provides
    fun providesAddMealPresenter(): AddMealPresenter {
        return AddMealPresenter()
    }
}