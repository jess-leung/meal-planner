package au.com.mealplanner.mealplanner.feature.addMeal

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
        presenter.onConfirmAddMeal("")

        verify(addMealView).showError()
    }

    @Test
    fun shouldSaveMealToDatabaseOnConfirmAddMealGivenMealNameAndMealType() {
        presenter.onConfirmAddMeal("Beef Pho")

        var meal: Meal = Meal("Beef Pho")
        verify(addMealView).saveMealToDatabase(meal)
    }
}