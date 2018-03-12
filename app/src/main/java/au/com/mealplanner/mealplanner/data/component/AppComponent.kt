package au.com.mealplanner.mealplanner.data.component

import android.app.Application
import au.com.mealplanner.mealplanner.MealPlannerApplication
import au.com.mealplanner.mealplanner.data.module.ActivityBindingModule
import au.com.mealplanner.mealplanner.data.module.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = arrayOf(ActivityBindingModule::class, ActivityModule::class))
interface AppComponent : AndroidInjector<MealPlannerApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: Application): Builder
        fun build(): AppComponent
    }
}