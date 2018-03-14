package au.com.mealplanner.mealplanner.data

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class MealPlannerScheduler {
    open fun io(): Scheduler {
        return Schedulers.io()
    }

    open fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}