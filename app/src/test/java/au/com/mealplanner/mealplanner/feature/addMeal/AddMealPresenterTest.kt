package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.feature.addMeal.AddMealPresenter.MealType.BREAKFAST
import au.com.mealplanner.mealplanner.feature.addMeal.AddMealPresenter.MealType.LUNCH
import au.com.mealplanner.mealplanner.data.model.Meal
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AddMealPresenterTest {
    private lateinit var presenter: AddMealPresenter
    private lateinit var addMealView: AddMealView

    @Before
    fun setUp() {
        presenter = AddMealPresenter()
        addMealView = mock(AddMealView::class.java)
        presenter.setView(addMealView)
    }

    @Test
    fun shouldShowErrorGivenNoMealName() {
        presenter.onConfirmAddMeal("", BREAKFAST)

        verify(addMealView).showError()
    }

    @Test
    fun shouldSaveMealToDatabaseOnConfirmAddMealGivenMealNameAndMealType() {
        presenter.onConfirmAddMeal("Beef Pho", LUNCH)

        var meal: Meal = Meal("Beef Pho", LUNCH)
        verify(addMealView).saveMealToDatabase(meal)
    }
}