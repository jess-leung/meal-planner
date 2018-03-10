package au.com.mealplanner.mealplanner.addMeal

import android.os.Bundle
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity

class AddMealActivity : BaseActivity(), AddMealView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_meal_activity)
        var presenter = AddMealPresenter()
        presenter.setView(this)
    }
}