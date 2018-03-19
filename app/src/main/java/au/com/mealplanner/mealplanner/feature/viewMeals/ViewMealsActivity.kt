package au.com.mealplanner.mealplanner.feature.viewMeals

import android.os.Bundle
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.Meal
import dagger.android.AndroidInjection
import javax.inject.Inject

class ViewMealsActivity : BaseActivity(), ViewMealView {
    override fun showError() {
    }

    override fun showMealList(mealList: List<Meal>) {
    }

    @Inject
    lateinit var activityPresenter: ViewMealsActivityPresenter

    override fun getLayoutId(): Int {
        return R.layout.view_meal_activity
    }

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPresenter.setView(this)

        activityPresenter.getMeals()
    }
}