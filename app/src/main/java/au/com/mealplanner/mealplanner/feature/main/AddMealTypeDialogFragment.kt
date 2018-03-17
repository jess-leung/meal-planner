package au.com.mealplanner.mealplanner.feature.main

import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.v7.app.AlertDialog
import au.com.mealplanner.mealplanner.R

class AddMealTypeDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(): AddMealTypeDialogFragment {
            val addMealTypeDialogFragment = AddMealTypeDialogFragment()
            return addMealTypeDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = activity.layoutInflater.inflate(R.layout.add_meal_type_dialog_fragment, null)
        builder.setView(view)
        builder.setTitle(getString(R.string.select_meal_type_dialog_title))
        builder.setPositiveButton("Done", { dialogInterface, whichButton ->
            dialogInterface.dismiss()
            (activity as WeeklyPlanActivity).showMealAddedSuccess()
        })
        builder.setNegativeButton("Cancel", { dialogInterface, whichButton -> dialogInterface.cancel() })
        isCancelable = false
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

}