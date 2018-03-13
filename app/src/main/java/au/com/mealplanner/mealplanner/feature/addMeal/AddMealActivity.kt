package au.com.mealplanner.mealplanner.feature.addMeal

import android.os.Bundle
import android.support.design.widget.Snackbar.LENGTH_LONG
import android.support.design.widget.Snackbar.make
import android.view.Menu
import android.view.MenuItem
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.Meal
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.add_meal_activity.*
import javax.inject.Inject

class AddMealActivity : BaseActivity(), AddMealView {
    override fun getLayoutId(): Int {
        return R.layout.add_meal_activity
    }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_white)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.confirm_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.confirm_action -> presenter.onConfirmAddMeal(meal_name_editText.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}