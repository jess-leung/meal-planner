package au.com.mealplanner.mealplanner.feature.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun goToAddMeal() {
        val intent = Intent(this, AddMealActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
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
}
