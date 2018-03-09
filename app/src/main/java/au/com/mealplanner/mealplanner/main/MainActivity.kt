package au.com.mealplanner.mealplanner.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.base.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val dayOfWeekList = ArrayList<String>()
        dayOfWeekList.add("Monday")
        dayOfWeekList.add("Tuesday")
        dayOfWeekList.add("Wednesday")
        dayOfWeekList.add("Thursday")
        dayOfWeekList.add("Friday")
        dayOfWeekList.add("Saturday")
        dayOfWeekList.add("Sunday")

        weekly_plan_recycler_view.layoutManager = LinearLayoutManager(this)
        weekly_plan_recycler_view.adapter = WeeklyPlanAdapter(dayOfWeekList)
    }
}
