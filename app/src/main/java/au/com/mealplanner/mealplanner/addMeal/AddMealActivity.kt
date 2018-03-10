package au.com.mealplanner.mealplanner.addMeal

import android.os.Bundle
import android.widget.ArrayAdapter
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import kotlinx.android.synthetic.main.add_meal_activity.*

class AddMealActivity : BaseActivity(), AddMealView {
    override fun setUpMealTypeSpinner(values: Array<AddMealPresenter.MealTypes>) {
        meal_type_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_meal_activity)
        var presenter = AddMealPresenter()
        presenter.setView(this)
        presenter.setUpMealTypes()
    }
}