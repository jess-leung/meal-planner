package au.com.mealplanner.mealplanner.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
}