package au.com.mealplanner.mealplanner.feature.main

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class WeeklyPlanActivityPresenterTest {

    private lateinit var presenter: WeeklyPlanActivityPresenter
    private lateinit var weeklyPlanView: WeeklyPlanView

    @Before
    fun setUp() {
        presenter = WeeklyPlanActivityPresenter()
        weeklyPlanView = mock(WeeklyPlanView::class.java)
        presenter.setView(weeklyPlanView)
    }

    @Test
    fun shouldGoToAddMeal() {
        presenter.goToAddMealActivity()

        verify(weeklyPlanView).goToAddMeal()
    }
}