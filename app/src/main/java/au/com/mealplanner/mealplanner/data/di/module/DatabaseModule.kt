package au.com.mealplanner.mealplanner.data.di.module

import android.arch.persistence.room.Room
import au.com.mealplanner.mealplanner.MealPlannerApplication
import au.com.mealplanner.mealplanner.data.db.MealPlannerDatabase
import au.com.mealplanner.mealplanner.data.db.dao.MealDao
import au.com.mealplanner.mealplanner.data.db.dao.PlannedMealDao
import au.com.mealplanner.mealplanner.data.db.repository.MealRepository
import au.com.mealplanner.mealplanner.data.db.repository.PlannedMealRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesMealPlannerDatabase(application: MealPlannerApplication): MealPlannerDatabase {
        return Room.databaseBuilder(application, MealPlannerDatabase::class.java, "meal-planner-db").build()
    }

    @Singleton
    @Provides
    fun providesMealDao(mealPlannerDatabase: MealPlannerDatabase): MealDao {
        return mealPlannerDatabase.getMealDao()
    }

    @Singleton
    @Provides
    fun providesPlannedMealDao(mealPlannerDatabase: MealPlannerDatabase): PlannedMealDao {
        return mealPlannerDatabase.getPlannedMealDao()
    }

    @Singleton
    @Provides
    fun providesMealRepository(mealDao: MealDao): MealRepository {
        return MealRepository(mealDao)
    }

    @Singleton
    @Provides
    fun providesPlannedMealRepository(plannedMealDao: PlannedMealDao): PlannedMealRepository {
        return PlannedMealRepository(plannedMealDao)
    }

}