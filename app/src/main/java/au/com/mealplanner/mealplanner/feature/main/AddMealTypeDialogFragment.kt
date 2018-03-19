package au.com.mealplanner.mealplanner.feature.main

import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.RadioButton
import android.widget.RadioGroup
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.data.model.MealType
import dagger.android.AndroidInjection
import javax.inject.Inject

class AddMealTypeDialogFragment : DialogFragment(), AddMealTypeView {


    @Inject
    lateinit var presenter: AddMealTypeDialogFragmentPresenter

    companion object {
        fun newInstance(): AddMealTypeDialogFragment {
            val addMealTypeDialogFragment = AddMealTypeDialogFragment()
            return addMealTypeDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        AndroidInjection.inject(this)
        presenter.setView(this)

        val builder = AlertDialog.Builder(activity)
        val view = activity.layoutInflater.inflate(R.layout.add_meal_type_dialog_fragment, null)
        builder.setView(view)
        builder.setTitle(getString(R.string.select_meal_type_dialog_title))
        builder.setPositiveButton("Done", { dialogInterface, whichButton ->
            dialogInterface.dismiss()
            val checkedMealTypeResId = view.findViewById<RadioGroup>(R.id.meal_type_selection_radiogroup).checkedRadioButtonId
            val checkedRadioMealType = view.findViewById<RadioButton>(checkedMealTypeResId)
            val mealType = MealType.valueOf(checkedRadioMealType.text.toString().toUpperCase())
            presenter.savePlannedMeal(arguments.get("added_meal") as Meal,
                    arguments.get("added_meal_day_of_week") as DayOfWeek, mealType)

        })
        builder.setNegativeButton("Cancel", { dialogInterface, whichButton -> dialogInterface.cancel() })
        isCancelable = false
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun updateWeeklyPlanView() {
        (activity as WeeklyPlanActivity).setUpWeeklyPlanView()
        (activity as WeeklyPlanActivity).showMealAddedSuccess()
    }

}