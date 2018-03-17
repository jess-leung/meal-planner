package au.com.mealplanner.mealplanner.feature.viewMeals

import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import dagger.android.AndroidInjection

class ViewMealsActivity : BaseActivity(), ViewMealView {
    override fun getLayoutId(): Int {
        return R.layout.view_meal_activity
    }

    override fun inject() {
        AndroidInjection.inject(this)
    }
}