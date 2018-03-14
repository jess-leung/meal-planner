package au.com.mealplanner.mealplanner.testUtil

import au.com.mealplanner.mealplanner.data.MealPlannerScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestMealPlannerScheduler: MealPlannerScheduler() {
    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }
}
