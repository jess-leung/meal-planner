package au.com.mealplanner.mealplanner.feature.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    @Inject
    lateinit var presenter: MainActivityPresenter

    private val ADD_MEAL_REQUEST_CODE: Int = 0

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun goToAddMeal() {
        val intent = Intent(this, AddMealActivity::class.java)
        startActivityForResult(intent, ADD_MEAL_REQUEST_CODE)
    }


    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)

        val dayOfWeekList = ArrayList<String>()
        dayOfWeekList.add("Monday")
        dayOfWeekList.add("Tuesday")
        dayOfWeekList.add("Wednesday")
        dayOfWeekList.add("Thursday")
        dayOfWeekList.add("Friday")
        dayOfWeekList.add("Saturday")
        dayOfWeekList.add("Sunday")

        weekly_plan_recycler_view.layoutManager = LinearLayoutManager(this)
        weekly_plan_recycler_view.adapter = WeeklyPlanAdapter(dayOfWeekList, presenter)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_MEAL_REQUEST_CODE) {
            val meal: Meal = data?.extras?.get("added_meal") as Meal
            Snackbar.make(add_meal_container, "Added Meal" + meal.mealName, Snackbar.LENGTH_LONG).show()
        }
    }
}
