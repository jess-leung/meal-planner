package au.com.mealplanner.mealplanner.feature.main

import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao.PlannedMealWithMeal
import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import au.com.mealplanner.mealplanner.data.model.DayOfWeek.MONDAY
import au.com.mealplanner.mealplanner.testUtil.TestMealPlannerScheduler
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class WeeklyPlanActivityPresenterTest {

    private lateinit var presenter: WeeklyPlanActivityPresenter
    private lateinit var weeklyPlanView: WeeklyPlanView

    private lateinit var plannedMealRepository: PlannedMealRepository

    @Before
    fun setUp() {
        plannedMealRepository = Mockito.mock(PlannedMealRepository::class.java)
        weeklyPlanView = mock(WeeklyPlanView::class.java)

        presenter = WeeklyPlanActivityPresenter(plannedMealRepository, TestMealPlannerScheduler())
        presenter.setView(weeklyPlanView)
    }

    @Test
    fun shouldGoToAddMeal() {
        presenter.goToAddMealActivity(MONDAY)

        verify(weeklyPlanView).goToAddMeal(MONDAY)
    }

    @Test
    fun shouldGetMealsGivenDayOfWeek() {
        val plannedMealWithMeal = PlannedMealWithMeal()
        plannedMealWithMeal.meal_name = "Teriyaki Chicken"
        plannedMealWithMeal.day_of_week = "MONDAY"
        plannedMealWithMeal.meal_type = "BREAKFAST"
        val plannedMeals = arrayListOf(plannedMealWithMeal)
        `when`(plannedMealRepository.getPlannedMeals()).thenReturn(Flowable.just(plannedMeals))

        presenter.getAllPlannedMeals()

        verify(plannedMealRepository).getPlannedMeals()
        verify(weeklyPlanView).updateWeeklyMealPlan(plannedMeals)
    }
}