package au.com.mealplanner.mealplanner.main

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MainActivityPresenterTest {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var mainView: MainView

    @Before
    fun setUp() {
        presenter = MainActivityPresenter()
        mainView = mock(MainView::class.java)
        presenter.setView(mainView)
    }

    @Test
    fun shouldGoToAddMeal() {
        presenter.goToAddMealActivity()

        verify(mainView).goToAddMeal()
    }
}