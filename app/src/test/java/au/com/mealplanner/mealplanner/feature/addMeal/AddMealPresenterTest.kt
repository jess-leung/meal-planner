package au.com.mealplanner.mealplanner.feature.addMeal

import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.testUtil.TestMealPlannerScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddMealPresenterTest {
    private lateinit var presenter: AddMealPresenter
    private lateinit var addMealView: AddMealView
    private lateinit var mealRepository: MealRepository

    @Before
    fun setUp() {
        addMealView = mock(AddMealView::class.java)
        mealRepository = mock(MealRepository::class.java)

        presenter = AddMealPresenter(mealRepository, TestMealPlannerScheduler())
        presenter.setView(addMealView)
    }

    @Test
    fun shouldShowErrorGivenNoMealName() {
        presenter.onConfirmAddMeal("")

        verify(addMealView).showError()
    }

    @Test
    fun shouldSaveMealToDatabaseOnConfirmAddMealGivenMealNameAndMealType() {
        val meal = Meal("Beef Pho")

        presenter.onConfirmAddMeal("Beef Pho")

        verify(mealRepository).insert(meal)
        verify(addMealView).goToMealPlanWithNewMeal(meal)
    }
}