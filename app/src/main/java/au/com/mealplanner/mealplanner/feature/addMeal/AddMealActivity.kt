package au.com.mealplanner.mealplanner.feature.addMeal

import android.os.Bundle
import android.support.design.widget.Snackbar.LENGTH_LONG
import android.support.design.widget.Snackbar.make
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.Meal
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.add_meal_activity.*
import javax.inject.Inject

class AddMealActivity : BaseActivity(), AddMealView {

    @Inject
    lateinit var presenter: AddMealPresenter

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun saveMealToDatabase(meal: Meal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        make(add_meal_container, "Oops", LENGTH_LONG).show()
    }

    override fun setUpMealTypeSpinner(values: Array<AddMealPresenter.MealType>) {
        meal_type_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_meal_activity)
        presenter.setView(this)
        presenter.setUpMealTypes()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.confirm_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.confirm_action -> presenter.onConfirmAddMeal(meal_name_editText.text.toString(), AddMealPresenter.MealType.BREAKFAST)
        }
        return super.onOptionsItemSelected(item)
    }
}