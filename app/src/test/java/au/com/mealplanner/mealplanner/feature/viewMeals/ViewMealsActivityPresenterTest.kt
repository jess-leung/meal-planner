package au.com.mealplanner.mealplanner.feature.viewMeals

import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.model.Meal
import au.com.mealplanner.mealplanner.testUtil.TestMealPlannerScheduler
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewMealsActivityPresenterTest {

    private lateinit var presenter: ViewMealsActivityPresenter

    private lateinit var mealRepository: MealRepository

    private lateinit var view: ViewMealView

    @Before
    fun setUp() {
        mealRepository = mock(MealRepository::class.java)
        view = mock(ViewMealView::class.java)
        presenter = ViewMealsActivityPresenter(mealRepository, TestMealPlannerScheduler())
        presenter.setView(view)
    }

    @Test
    fun shouldFetchMealsFromMealRepository() {
//
        // given
         var mealList = ArrayList<Meal>()
        mealList.add(Meal("Teriyaki Chicken"))
        `when`(mealRepository.fetchAll()).thenReturn(Flowable.just(mealList))

        //when
        presenter.getMeals()

        //then
        verify(mealRepository).fetchAll()
        verify(view).showMealList(mealList)
    }
}