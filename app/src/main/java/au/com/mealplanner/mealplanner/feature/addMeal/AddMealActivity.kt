package au.com.mealplanner.mealplanner.feature.addMeal

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar.LENGTH_LONG
import android.support.design.widget.Snackbar.make
import android.view.Menu
import android.view.MenuItem
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.add_meal_activity.*
import java.io.Serializable
import javax.inject.Inject

class AddMealActivity : BaseActivity(), AddMealView {
    override fun goToMealPlanWithNewMeal(meal: Meal) {
        var intent = Intent(this, WeeklyPlanActivity::class.java)
        intent.putExtra("added_meal", meal as Serializable)
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun getLayoutId(): Int {
        return R.layout.add_meal_activity
    }

    @Inject
    lateinit var activityPresenter: AddMealActivityPresenter

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun showError() {
        make(add_meal_container, "Oops", LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPresenter.setView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_white)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.confirm_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.confirm_action -> activityPresenter.onConfirmAddMeal(meal_name_editText.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}