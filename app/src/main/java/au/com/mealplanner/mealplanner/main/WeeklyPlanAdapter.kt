package au.com.mealplanner.mealplanner.main

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.addMeal.AddMealActivity
import au.com.mealplanner.mealplanner.main.WeeklyPlanAdapter.WeeklyPlanViewHolder

class WeeklyPlanAdapter(dayOfWeekList: List<String>, presenter: MainActivityPresenter) : RecyclerView.Adapter<WeeklyPlanViewHolder>() {

    val weekList: List<String> = dayOfWeekList
    val presenter: MainActivityPresenter = presenter

    override fun onBindViewHolder(holder: WeeklyPlanViewHolder?, position: Int) {
        val dayOfWeek = weekList.get(position)
        holder?.dayLabel?.text = dayOfWeek
        holder?.addMealButton?.setOnClickListener({
            presenter.goToAddMealActivity()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeeklyPlanViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.meal_day_plan_card, parent, false)
        return WeeklyPlanViewHolder(v)
    }

    override fun getItemCount(): Int {
        return weekList.size
    }

    inner class WeeklyPlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dayLabel: TextView = view.findViewById(R.id.day_label)
        var addMealButton: Button = view.findViewById(R.id.add_meal_button)
    }
}