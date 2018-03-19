package au.com.mealplanner.mealplanner.feature.main

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanAdapter.WeeklyPlanViewHolder

class WeeklyPlanAdapter(private val presenter: WeeklyPlanActivityPresenter,
                        private val context: Context) : RecyclerView.Adapter<WeeklyPlanViewHolder>() {

    private lateinit var weeklyPlanData: List<PlannedMealDao.PlannedMealWithMeal>

    override fun onBindViewHolder(holder: WeeklyPlanViewHolder?, position: Int) {
        val dayOfWeek = presenter.dayOfWeekList.get(position)
        val filteredMealList = weeklyPlanData.filter {
            dayOfWeek.name.equals(it.day_of_week)
        }
        holder?.dayLabel?.text = dayOfWeek.name
        holder?.addMealButton?.setOnClickListener({
            presenter.goToAddMealActivity(dayOfWeek)
        })
        holder?.mealsContainer?.removeAllViews()
        setUpMealsForDayOfWeek(holder, filteredMealList)
    }

    private fun setUpMealsForDayOfWeek(holder: WeeklyPlanViewHolder?, filteredMealList: List<PlannedMealDao.PlannedMealWithMeal>) {
        if (filteredMealList.isNotEmpty()) {
            holder?.noMealsText?.visibility = View.GONE

            filteredMealList.forEach {
                val rowLayout = (context as Activity).layoutInflater.inflate(R.layout.meal_day_plan_meal_row, null) as LinearLayout
                val mealType = rowLayout.findViewById<TextView>(R.id.meal_type)
                val mealName = rowLayout.findViewById<TextView>(R.id.meal_name)
                mealType.text = it.meal_type
                mealName.text = it.meal_name
                holder?.mealsContainer?.addView(rowLayout)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeeklyPlanViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.meal_day_plan_card, parent, false)
        return WeeklyPlanViewHolder(v)
    }

    override fun getItemCount(): Int {
        return presenter.dayOfWeekList.size
    }

    inner class WeeklyPlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dayLabel: TextView = view.findViewById(R.id.day_label)
        var addMealButton: Button = view.findViewById(R.id.add_meal_button)
        var noMealsText: TextView = view.findViewById(R.id.no_meals_text)
        var mealsContainer: LinearLayout = view.findViewById(R.id.meals_container)
    }

    fun setWeeklyPlanData(plannedMeals: List<PlannedMealDao.PlannedMealWithMeal>) {
        weeklyPlanData = plannedMeals
    }
}