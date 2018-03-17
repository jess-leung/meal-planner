package au.com.mealplanner.mealplanner.data.model

data class PlannedMeal (
        var meal: Meal,
        var dayOfWeek: String,
        var mealType: MealType
)