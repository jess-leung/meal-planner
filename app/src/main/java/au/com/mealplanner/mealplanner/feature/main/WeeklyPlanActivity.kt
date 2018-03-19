package au.com.mealplanner.mealplanner.feature.main

import android.app.Activity
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.weekly_plan_activity.*
import java.io.Serializable
import javax.inject.Inject

class WeeklyPlanActivity : BaseActivity(), WeeklyPlanView {
    override fun showError() {
        Snackbar.make(add_meal_container, "Error getting meal plan", Snackbar.LENGTH_LONG).show()
    }

    @Inject
    lateinit var presenter: WeeklyPlanActivityPresenter

    private lateinit var weeklyPlanAdapter: WeeklyPlanAdapter

    private val ADD_MEAL_REQUEST_CODE: Int = 0
    private val MEAL_DAY_OF_WEEK: String = "DAY_OF_WEEK"

    override fun updateWeeklyMealPlan(plannedMeals: List<PlannedMealDao.PlannedMealWithMeal>) {
        weeklyPlanAdapter.setWeeklyPlanData(plannedMeals)
        weeklyPlanAdapter.notifyDataSetChanged()
    }

    override fun setUpWeeklyPlanView() {
        presenter.getAllPlannedMeals()
    }

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
        weekly_plan_recycler_view.layoutManager = LinearLayoutManager(this)
        weeklyPlanAdapter = WeeklyPlanAdapter(presenter, this)
        weekly_plan_recycler_view.adapter = weeklyPlanAdapter

        presenter.getAllPlannedMeals()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_MEAL_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val meal: Meal = data?.extras?.get("added_meal") as Meal
                val dayOfWeek = data?.extras?.get("added_meal_day_of_week") as DayOfWeek
                var bundle = Bundle()
                bundle.putSerializable("added_meal_day_of_week", dayOfWeek)
                bundle.putSerializable("added_meal", meal)
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                val addMealTypeDialogFragment = AddMealTypeDialogFragment.newInstance()
                addMealTypeDialogFragment.arguments = bundle
                addMealTypeDialogFragment.show(fragmentTransaction, "AddMealDialog")
            }
        }
    }

    override fun showMealAddedSuccess() {
        Snackbar.make(add_meal_container, "Meal added.", Snackbar.LENGTH_LONG).show()
    }
}
