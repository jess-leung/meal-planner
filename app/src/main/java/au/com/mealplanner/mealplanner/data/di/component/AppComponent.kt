package au.com.mealplanner.mealplanner.data.di.component

import android.app.Application
import au.com.mealplanner.mealplanner.MealPlannerApplication
import au.com.mealplanner.mealplanner.data.di.module.ActivityBindingModule
import au.com.mealplanner.mealplanner.data.di.module.ActivityModule
import au.com.mealplanner.mealplanner.data.di.module.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityBindingModule::class, ActivityModule::class, DatabaseModule::class))
interface AppComponent : AndroidInjector<MealPlannerApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: MealPlannerApplication): Builder
        fun build(): AppComponent
    }
}