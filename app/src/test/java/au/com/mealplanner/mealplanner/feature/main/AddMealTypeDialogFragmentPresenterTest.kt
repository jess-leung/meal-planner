package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import au.com.mealplanner.mealplanner.data.model.DayOfWeek.TUESDAY
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.data.model.MealType.BREAKFAST
import au.com.mealplanner.mealplanner.data.model.PlannedMeal
import au.com.mealplanner.mealplanner.testUtil.TestMealPlannerScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class AddMealTypeDialogFragmentPresenterTest {
    private lateinit var presenter: AddMealTypeDialogFragmentPresenter

    private lateinit var plannedMealRepository: PlannedMealRepository

    private lateinit var view: AddMealTypeView

    @Before
    fun setUp() {
        view = Mockito.mock(AddMealTypeView::class.java)
        plannedMealRepository = Mockito.mock(PlannedMealRepository::class.java)
        presenter = AddMealTypeDialogFragmentPresenter(plannedMealRepository, TestMealPlannerScheduler())
        presenter.setView(view)
    }

    @Test
    fun shouldSavePlannedMeal() {
        val meal = Meal()
        meal.id = 1

        presenter.savePlannedMeal(meal, TUESDAY, BREAKFAST)

        verify(plannedMealRepository).insert(PlannedMeal(1, TUESDAY.name, BREAKFAST.name))
        verify(view).updateWeeklyPlanView()
    }
}
