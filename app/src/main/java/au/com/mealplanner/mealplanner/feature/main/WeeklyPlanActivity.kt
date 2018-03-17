package au.com.mealplanner.mealplanner.feature.main

import android.app.Activity
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.DayOfWeek.*
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.weekly_plan_activity.*
import java.io.Serializable
import javax.inject.Inject

class WeeklyPlanActivity : BaseActivity(), WeeklyPlanView {
    @Inject
    lateinit var presenter: WeeklyPlanActivityPresenter

    private val ADD_MEAL_REQUEST_CODE: Int = 0
    private val MEAL_DAY_OF_WEEK: String = "DAY_OF_WEEK"

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun goToAddMeal(dayOfWeek: DayOfWeek) {
        var intent = Intent(this, AddMealActivity::class.java)
        intent.putExtra(MEAL_DAY_OF_WEEK, dayOfWeek as Serializable)
        startActivityForResult(intent, ADD_MEAL_REQUEST_CODE)
    }


    override fun getLayoutId(): Int {
        return R.layout.weekly_plan_activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)

        val dayOfWeekList = ArrayList<DayOfWeek>()
        dayOfWeekList.add(MONDAY)
        dayOfWeekList.add(TUESDAY)
        dayOfWeekList.add(WEDNESDAY)
        dayOfWeekList.add(THURSDAY)
        dayOfWeekList.add(FRIDAY)
        dayOfWeekList.add(SATURDAY)
        dayOfWeekList.add(SUNDAY)

        weekly_plan_recycler_view.layoutManager = LinearLayoutManager(this)
        weekly_plan_recycler_view.adapter = WeeklyPlanAdapter(dayOfWeekList, presenter)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_MEAL_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val meal: Meal = data?.extras?.get("added_meal") as Meal
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                val addMealTypeDialogFragment = AddMealTypeDialogFragment.newInstance()
                addMealTypeDialogFragment.show(fragmentTransaction, "AddMealDialog")
            }
        }
    }

    fun showMealAddedSuccess() {
        Snackbar.make(add_meal_container, "Meal added", Snackbar.LENGTH_LONG).show()
    }
}
