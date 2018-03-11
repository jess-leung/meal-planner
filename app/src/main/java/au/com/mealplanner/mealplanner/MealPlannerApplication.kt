package au.com.mealplanner.mealplanner

import android.app.Activity
import android.app.Application
import au.com.mealplanner.mealplanner.data.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MealPlannerApplication : Application(), HasActivityInjector {

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = mAndroidInjector

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .app(this)
                .build().inject(this)
    }


}

