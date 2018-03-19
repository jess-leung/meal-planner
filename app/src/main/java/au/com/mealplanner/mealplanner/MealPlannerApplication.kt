package au.com.mealplanner.mealplanner

import android.app.Activity
import android.app.Application
import android.app.Fragment
import au.com.mealplanner.mealplanner.data.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class MealPlannerApplication : Application(), HasActivityInjector, HasFragmentInjector {

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = mAndroidActivityInjector

    override fun fragmentInjector(): DispatchingAndroidInjector<Fragment> = mAndroidFragmentInjector

    @Inject
    lateinit var mAndroidActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .app(this)
                .build().inject(this)
    }


}

